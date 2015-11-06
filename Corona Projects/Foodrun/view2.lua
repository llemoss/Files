-----------------------------------------------------------------------------------------
--
-- view2.lua
--
-----------------------------------------------------------------------------------------
local composer = require( "composer" )
local widget = require "widget"
local scene = composer.newScene()

function scene:create( event )
	local sceneGroup = self.view
	
	-- Called when the scene's view does not exist.
	-- 
	-- INSERT code here to initialize the scene
	-- e.g. add display objects to 'sceneGroup', add touch listeners, etc.
	
	-- create a white background to fill screen
	local bg = display.newRect( 0, 0, display.contentWidth, display.contentHeight )
	bg.anchorX = 0
	bg.anchorY = 0
	bg:setFillColor( 1 )	-- white
	
	local latitudeText = display.newText( "-", 100, 50, native.systemFont, 16 )
	latitudeText:setFillColor( 0 )
	local longitudeText = display.newText( "-", 100, 100, native.systemFont, 16 )
	longitudeText:setFillColor( 0 )
	local altitudeText = display.newText( "-", 100, 150, native.systemFont, 16 )
	altitudeText:setFillColor( 0 )
	local accuracyText = display.newText( "-", 100, 200, native.systemFont, 16 )
	accuracyText:setFillColor( 0 )
	local speedText = display.newText( "-", 100, 250, native.systemFont, 16 )
	speedText:setFillColor( 0 )
	local directionText = display.newText( "-", 100, 300, native.systemFont, 16 )
	directionText:setFillColor( 0 )
	local timeText = display.newText( "-", 100, 350, native.systemFont, 16 )
	timeText:setFillColor( 0 )
	
	local function update()
		print("Updating values...")
		latitudeText.text = string.format( '%.4f', latitude )
		longitudeText.text = string.format( '%.4f', longitude )
		altitudeText.text = string.format( '%.4f', altitude )
		accuracyText.text =string.format( '%.4f', accuracy )
		speedText.text = string.format( '%.4f', speed )
		directionText.text = string.format( '%.4f', direction )
		timeText.text = string.format( '%.4f', time )
	end
	
	updateTimer = timer.performWithDelay(1000, update, 0)
	
	-- all objects must be added to group (e.g. self.view)
	sceneGroup:insert( bg )
	sceneGroup:insert( latitudeText)
	sceneGroup:insert(longitudeText)
	sceneGroup:insert(altitudeText)
	sceneGroup:insert(accuracyText)
	sceneGroup:insert(speedText)
	sceneGroup:insert(directionText)
	sceneGroup:insert(timeText)
	
end

function scene:show( event )
	local sceneGroup = self.view
	local phase = event.phase
	
	if phase == "will" then
		-- Called when the scene is still off screen and is about to move on screen
	elseif phase == "did" then
		-- Called when the scene is now on screen
		-- 
		-- INSERT code here to make the scene come alive
		-- e.g. start timers, begin animation, play audio, etc.
	end	
end

function scene:hide( event )
	local sceneGroup = self.view
	local phase = event.phase
	
	if event.phase == "will" then
		-- Called when the scene is on screen and is about to move off screen
		--
		-- INSERT code here to pause the scene
		-- e.g. stop timers, stop animation, unload sounds, etc.)
	elseif phase == "did" then
		-- Called when the scene is now off screen
	end
end

function scene:destroy( event )
	local sceneGroup = self.view
	
	-- Called prior to the removal of scene's "view" (sceneGroup)
	-- 
	-- INSERT code here to cleanup the scene
	-- e.g. remove display objects, remove touch listeners, save state, etc.
end

---------------------------------------------------------------------------------

-- Listener setup
scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )
scene:addEventListener( "hide", scene )
scene:addEventListener( "destroy", scene )

-----------------------------------------------------------------------------------------

return scene