## The game/player interface

At a basic level, the game loop needs to defer to each player the decision to hit or stand. That's fine for well-behaved players.  But what happens when things aren't well behaved?

### A slow player
[Example slow player](/src/main/java/com.sweeneyb.blackjack.players.SlowPlayer.java)

At some point, a slow player detracts from the experience of the other players.  So while an interface to defer to the player to "do your turn" would be nice, it clearly needs a timeout.

### A player that doesn't know the rules
[This player hits after a bust](/src/main/java/com.sweeneyb.blackjack.players.HitTooMuchPlayer.java)
The defer model also breaks down  