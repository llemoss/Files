-----------------------------------------------------------------------------------------
--
-- view1.lua
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
	
	-- create some text
	local title = display.newText( "Location", 0, 0, native.systemFont, 32 )
	title:setFillColor( 0 )	-- black
	title.x = display.contentWidth * 0.5
	title.y = 50
	
	local distanciaPercorrida
	local tempoPercorrido
	local velocidadeMedia = 0
	local calorias = 0
	local velBtn
	
	local function calcDist()
		local lat1 = xInicial
		local lat2 = xFinal
		local long1 = yInicial
		local long2 = yFinal
		local R = 6378.137
		local dLat = (lat2 - lat1) * (math.pi / 180)
		local dLon = (long2  - long1) * (math.pi / 180)
		local a = math.sin(dLat/2) * math.sin(dLat/2) +	math.cos(lat1 * math.pi / 180) * math.cos(lat2 * math.pi / 180) * math.sin(dLon/2) * math.sin(dLon/2)
		local c = 2 * math.atan2(math.sqrt(a), math.sqrt(1-a))
		local d = R * c
		return d
	end
	
	local function setStart()
		xInicial = latitude
		yInicial = longitude
		tInicial = time
	end
	
	-- GASTO CALÓRICO EM CALORIAS/ MIN = VELOCIDADE(KM/H) X PESO (Kg) x 0,0175
	
	local velText = display.newText(string.format("Velocidade: %0.4f", velocidadeMedia), display.contentWidth*0.5, display.contentHeight*0.5)
	velText:setFillColor(0, 0, 0)
	velText.x = display.contentWidth*0.5
	velText.y = 270
	
	local calText = display.newText(string.format("Calorias: %0.4f", calorias), display.contentWidth*0.5, display.contentHeight*0.5)
	calText:setFillColor(0, 0, 0)
	calText.x = display.contentWidth*0.5
	calText.y = 300
	
	local function calcCalorias()
		if velocidadeMedia ~= nil and peso ~= nil then
			calorias = velocidadeMedia * peso * 0.0175
			return calorias
		end
	end
	
	local defaultField

	local function textListener( event )
		if ( event.phase == "ended" or event.phase == "submitted" ) then
			peso = event.target.text
			defaultField:removeSelf()
		end
	end

	defaultField = native.newTextField( 150, 150, 180, 30 )
	defaultField.x = display.contentWidth*0.5
	defaultField.y = 350
	defaultField.inputType = "number"
	defaultField:addEventListener( "userInput", textListener )
		
	local function velCalc()
		xFinal = latitude
		yFinal = longitude
		tFinal = time
		distanciaPercorrida = calcDist()
		velocidadeMedia = distanciaPercorrida / (tFinal/3600 - tInicial/3600)
		velText.text = string.format("Velocidade: %f", velocidadeMedia)
		if peso ~= nil then
			calorias = calcCalorias()
			calText.text = string.format("Calorias: %f", calorias)
		end
	end
	
	local velBtn = widget.newButton{
		label="Calcular velocidade",
		shape="roundedRect",
		cornerRadius = 7,
		labelColor = { default={0} },
		fillColor = { default= { 25, 118, 210, 0.3 }, over= { 1, 87, 155, 0.1 } },
		width=110, height=30,
		fontSize=20,
		onRelease = velCalc
	}
	
	local startBtn = widget.newButton{
		label="Set start point",
		shape="roundedRect",
		cornerRadius = 7,
		labelColor = { default={0} },
		fillColor = { default= { 25, 118, 210, 0.3 }, over= { 1, 87, 155, 0.1 } },
		width=110, height=30,
		fontSize=20,
		onRelease = setStart
	}
	
	local newTextParams = { text = "Loaded by the first tab's\n\"onPress\" listener\nspecified in the 'tabButtons' table", 
						x = 0, y = 0, 
						width = 310, height = 310, 
						font = native.systemFont, fontSize = 14, 
						align = "center" }
	velBtn.x = display.contentWidth * 0.5
	velBtn.y = title.y + 100
	startBtn.x = display.contentWidth * 0.5
	startBtn.y = title.y + 150
	
	-- all objects must be added to group (e.g. self.view)
	sceneGroup:insert( bg )
	sceneGroup:insert( title )
	sceneGroup:insert( velBtn )
	sceneGroup:insert( startBtn )
	sceneGroup:insert( velText )
	sceneGroup:insert ( calText)
	sceneGroup:insert (defaultField)
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