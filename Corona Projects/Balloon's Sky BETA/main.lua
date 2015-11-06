local composer = require( "composer" )
local widget = require( "widget" )
local ads = require( "ads" )
local store = require( "store" )
local gameNetwork = require("gameNetwork")
local utility = require( "utility" )
local myData = require( "mydata" )
local device = require( "device" )

display.setStatusBar( display.HiddenStatusBar )

math.randomseed( os.time() )

if device.isAndroid then
	widget.setTheme( "widget_theme_android_holo_light" )
    store = require("plugin.google.iap.v3")
end

--
-- Load saved in settings
--
myData.settings = utility.loadTable("settings.json")
if myData.settings == nil then
	myData.settings = {}
	myData.settings.soundOn = true
	myData.settings.musicOn = true
    myData.settings.isPaid = false
	myData.settings.greenTutorial = true
	myData.settings.yellowTutorial = true
	myData.settings.bombTutorial = true
	myData.settings.blackbombTutorial = true
	myData.settings.greenTutorialTimed = true
	myData.settings.yellowTutorialTimed = true
	myData.settings.missedTutorial = true
	myData.settings.purpleTutorial = true
	utility.saveTable(myData.settings, "settings.json")
end

local function adListener( event )
   for k,v in pairs( event ) do
      print("adListener ", k, v ) -- so you see everything you get
   end
end

ads.init("admob", interstitialID, adListener )
ads:setCurrentProvider("admob")

--
-- Initialize gameNetwork
--
local function showLeaderboards()
		gameNetwork.show("leaderboards")
		print("Trying to show leaderboards")
end

local function submitScoreListener(event)
	if level == "timed" then
		leaderboardId = "CgkIuNfVtdgXEAIQCQ"
	else
		leaderboardId = "CgkIuNfVtdgXEAIQBw"
	end
	gameNetwork.request("setHighScore", 
		{
			localPlayerScore = 
			{
				category = leaderboardId,
				value = score
			}
		})
	scoreSubmitButton:removeSelf()
	print("Score submitted:", score)
	scoreSubmitButton = widget.newButton{
		width=120, height=30,
		label = boardsTranslated[language],
		shape="roundedRect",
		cornerRadius = 6,
		labelColor = { default={255} },
		fillColor = { default= { 25, 118, 210, 0.4 }, over= { 1, 87, 155, 0.1 } },
		font=pixelFont,
		fontSize=24,
		onRelease = showLeaderboards,
	}
	if timesReplayed >= 1 then
		scoreSubmitButton.x = display.contentWidth*0.5 - 65
	else
		scoreSubmitButton.x = display.contentWidth*0.5
	end
	scoreSubmitButton.y = display.contentHeight - 85
	
end

local function unlockAchievement(achievementId)
	gameNetwork.request("unlockAchievement",
		{
			achievement = 
			{
				identifier = achievementId -- The id of the achievement to unlock for the current user
			}
		})
end

local function showAchievementsListener(event)
	gameNetwork.show("achievements") -- Shows the locked and unlocked achievements.
end

local function loginLogout()
	local function loginListener(event)
		-- Checks to see if there was an error with the login.
		if event.isError then
			print("Login successful")
		else
			print("Error with login")
		end
	end
	gameNetwork.request("login",
			{
				listener = loginListener,
				userInitiated = true
			})
	end
--
-- Put your gameNetwork login handling code here
--

--
-- Load your global sounds here
-- Load scene specific sounds in the scene
--
musicStream = audio.loadStream("music3.mp3")
bombPop = audio.loadSound("bomb.wav")
balloonPop = audio.loadSound("balloon.wav") --Credits to https://goo.gl/noA3Qk
bonusPop = audio.loadSound("bonus.mp3")
--

--
-- Other system events
--
local function onKeyEvent( event )

    local phase = event.phase
    local keyName = event.keyName
    print( event.phase, event.keyName )

    if ( "back" == keyName and phase == "up" ) then
        if ( composer.getCurrentSceneName() == "menu" ) then
            native.requestExit()
        else
            composer.gotoScene( "menu", { effect="crossFade", time=500 } )
        end
        return true
    end
    return false
end

--add the key callback
if device.isAndroid then
    Runtime:addEventListener( "key", onKeyEvent )
end

--
-- handle system events
--
local function systemEvents(event)
    print("systemEvent " .. event.type)
    if event.type == "applicationSuspend" then
        utility.saveTable( myData.settings, "settings.json" )
    elseif event.type == "applicationResume" then
        -- 
        -- login to gameNetwork code here
        --
    elseif event.type == "applicationExit" then
        utility.saveTable( myData.settings, "settings.json" )
    elseif event.type == "applicationStart" then
        --
        -- Login to gameNetwork code here
        --
        --
        -- Go to the menu
        --
        composer.gotoScene( "menu", { time = 250, effect = "fade" } )
    end
    return true
end
Runtime:addEventListener("system", systemEvents)
