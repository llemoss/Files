-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------

-- show default status bar (iOS)
display.setStatusBar( display.DefaultStatusBar )

-- include Corona's "widget" library
local widget = require "widget"
local composer = require "composer"


-- event listeners for tab buttons:
local function onFirstView( event )
	composer.gotoScene( "view1" )
end

local function onSecondView( event )
	composer.gotoScene( "view2" )
end

local locationHandler = function( event )

		-- Check for error (user may have turned off location services)
		if ( event.errorCode ) then
			native.showAlert( "GPS Location Error", event.errorMessage, {"OK"} )
			print( "Location error: " .. tostring( event.errorMessage ) )
		else
			latitude = event.latitude
			longitude = event.longitude 
			altitude = event.altitude
			accuracy = event.accuracy
			speed = event.speed
			direction = event.direction
			-- Note that 'event.time' is a Unix-style timestamp, expressed in seconds since Jan. 1, 1970
			time = event.time
		end
end
	

	-- Activate location listener
Runtime:addEventListener( "location", locationHandler )

-- create a tabBar widget with two buttons at the bottom of the screen

-- table to setup buttons
local tabButtons = {
	{ label="First", onPress=onFirstView, selected=true },
	{ label="Second", onPress=onSecondView },
}

-- create the actual tabBar widget
local tabBar = widget.newTabBar{
	top = display.contentHeight - 50,	-- 50 is default height for tabBar widget
	left = 0,
	width = display.contentWidth,
	buttons = {
	{ label="First", size=20, onPress=onFirstView, selected=true },
	{ label="Second", size=20, onPress=onSecondView },}
}

onFirstView()	-- invoke first tab button's onPress event manually