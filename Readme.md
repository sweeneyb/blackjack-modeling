## The game/player interface

At a basic level, the game loop needs to defer to each player the decision to hit or stand. That's fine for well-behaved players.  But what happens when things aren't well behaved?

### A slow player
[Example slow player](/src/main/java/com/sweeneyb/blackjack/players/SlowPlayer.java)

At some point, a slow player detracts from the experience of the other players.  So while an interface to defer to the player to "do your turn" would be nice, it clearly needs a timeout.  This would also fix a potential issue with a player leaving mid-turn.

### A player that doesn't know the rules
[This player hits after a bust](/src/main/java/com/sweeneyb/blackjack/players/HitTooMuchPlayer.java)
The defer model also breaks down when the player doesn't know the ruls.  Hitting after a (visible) bust is disallowed by the game rules.  But in a simple interface, it's hard to enforce that.

### What's my score?
[This player never loses](/src/main/java/com/sweeneyb/blackjack/players/CheatingPlayer.java)
The interface here also relies on the player to report its own score.  While this could work for trusted code, untrusted code can easily take advantage of the trust to cheat.

### Stealing cards after a turn
This interface also exposes the "game" pointer.  There's nothing to stop a client from saving a copy of the game and, after turn completion, asking the game to deal a bunch of cards for no apparent reason.  That would exhaust the shoe and throw off other players.

## There's a lot there
How the interface is constructed may change based on how the application is deployed.  If this is a desktop app where the user clicks buttons to make choices, we might be able to assume more trust in the code and make some simplifying assumptions.
If this is deployed as a webapp where multiple untrusted clients are playing (over a network), there are a whole different set of considerations that need to be addressed. 
