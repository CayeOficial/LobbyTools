



[SPOILER="Config"]
[code=YAML]#####################################################
#                                                   #
#                 BY CAYEOFICIAL                    #
#                                                   #
#####################################################

#VARIABLES:
#Player name = %player_name%
Config:
  #Enable or disable the block place to everyone except people with "lobbytools.admin" permission
  #False: disabled | True: enabled
  block-place: false
  #Enable or disable the block break to everyone except people with "lobbytools.admin" permission
  #False: disabled | True: enabled
  block-break: false
  #Enable the chat?
  enable-chat: true
  #Enable or disable damage & pvp from players
  #Damage: Fall damage, damage by mobs, etc...
  #PvP: Fight between players
  enable-damage: false
  enable-pvp: false
  #Enable hunger?
  enable-hunger: false
  #Enable interactions with chest, trapdoors, doors, etc.?
  player-interact: false

OnJoin:
  #Send a message to a player when he joins
  enable-message-on-join: true
  #The message that will be sent to the player when he joins if "enable-message-on-join" is true
  #sUse %player_name% for player name & \n for break line
  join-message: "&6&lWELCOME &f%player_name% &6&lTO &fYourServer\nThanks for use LobbyTools"
  #Launch a firework when a player join
  #This setting is quite funny, I recommend leave it to true
  launch-firework-on-join: true
  #Send a title to a player when he joins
  send-title-on-join: true
  #Message of the title and subtitle that will be sent to the player when he joins if "send-title-on-join" is on true
  title-message: "&aHi %player_name%"
  subtitle-message: "Welcome back!"

Spawn:
  #Teleport the player to the spawn when he joins the server
  teleport-player-to-spawn: true
  ###############
  #   WARNING   #
  ###############
  #Please do not modify this, use "/setspawn" command in-game for set the spawn
  world: "world"
  x: 100
  y: 100
  z: 100
  pitch: 90
  yaw: 90
  #Message sent to the player when he ran /setspawn command
  spawn-set-message: "&aThe spawn has been successfully set"



Messages:
  #Message sent to a player that tried to break/place blocks without permission
  cannot-place-blocks: "&cSorry! You can't place blocks here"
  cannot-break-blocks: "&cSorry! You can't break blocks here"
  #Message sent to a player when he talks on the chat but the chat is disabled
  chat-is-disabled: "&cThe chat is disabled"
  #Message sent when the plugin configuration has been reloaded
  reload-message: "&cThe plugin has been reloaded"
  #Message sent when console executes the command /setspawn
  cannot-execute-by-console: "This command can't be executed by console"
  #Message sent to a player if he tries to execute a command without perms (this doesn't include break/place blocks, for that edit the 2 first messages)
  no-permission-error: "&cYou don't have permission to execute this command"
[/code]
[/SPOILER][SPOILER="Support"]If you are having troubles on configuration/bugs/suggestions, you can always get in touch with me for further help/fix.
My discord is zCayeOficial#0001. If you wish, you can also DM me on spigot.[/SPOILER][SPOILER="ToS"]
[code]As my plugin is free, you must read and follow this terms and conditions to support me!

1. You can't claim the resource as yours.
2. Don't publish the same resource on another resource forums.
3. If you edit the plugin's source code, you must give credits to the author.
4. The author is not responsible for damage on server caused by wrong configuration or plugin modified.
5. No personal data is sent, this plugin doesn't use any software like bStats or PluginMetrics.

If you need help, feel free to contact me.[/code]
[/SPOILER]
