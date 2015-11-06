-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------

-- Your code here
widget 	 = require ("widget")
loadsave = require( "loadsave" ) 


local bg = display.newRect( 0, 0, display.contentWidth, display.contentHeight )
bg.anchorX = 0
bg.anchorY = 0
bg:setFillColor( 1 )

local function scrollListener(event)

		local phase = event.phase
		if ( phase == "began" ) then print( "Scroll view was touched" )
		elseif ( phase == "moved" ) then print( "Scroll view was moved" )
		elseif ( phase == "ended" ) then print( "Scroll view was released" )
		end

		-- In the event a scroll limit is reached...
		if ( event.limitReached ) then
			if ( event.direction == "up" ) then print( "Reached top limit" )
			elseif ( event.direction == "down" ) then print( "Reached bottom limit" )
			elseif ( event.direction == "left" ) then print( "Reached left limit" )
			elseif ( event.direction == "right" ) then print( "Reached right limit" )
			end
		end

		return true
	end

chiqueiroText = display.newText("Chiqueiro\nOferece churrasco entre as 18h e 00h\nPreços variam entre 40 e 150\nreais por prato\n", 0, 0, native.systemFont, 15)
chiqueiroText:setFillColor(0)
chiqueiroText.x = display.contentWidth*0.5 - 15
chiqueiroText.y = display.contentHeight*0.5 - 190

pizzaText = display.newText("Pizzaria\nOferece pizza entre as 16h e 22h\nPreços variam entre 40 e 60\nreais por prato\n", 0, 0, native.systemFont, 15)
pizzaText:setFillColor(0)
pizzaText.x = chiqueiroText.x - 15
pizzaText.y = chiqueiroText.y + 90

nemiText = display.newText("Nemi\nOferece comida sem glúten entre as\n11h e 14h\nPreços variam entre ?? e ??\nreais por prato\n", 0, 0, native.systemFont, 15)
nemiText:setFillColor(0)
nemiText.x = chiqueiroText.x - 7
nemiText.y = pizzaText.y + 100

nemi2Text = display.newText("Nemi\nOferece comida sem glúten entre as\n11h e 14h\nPreços variam entre ?? e ??\nreais por prato\n", 0, 0, native.systemFont, 15)
nemi2Text:setFillColor(0)
nemi2Text.x = chiqueiroText.x - 7
nemi2Text.y = nemiText.y + 100

nemi3Text = display.newText("Nemi\nOferece comida sem glúten entre as\n11h e 14h\nPreços variam entre ?? e ??\nreais por prato\n", 0, 0, native.systemFont, 15)
nemi3Text:setFillColor(0)
nemi3Text.x = chiqueiroText.x - 7
nemi3Text.y = nemi2Text.y + 100

listOfCardapius = display.newGroup()
listOfCardapius:insert(chiqueiroText)
listOfCardapius:insert(pizzaText)
listOfCardapius:insert(nemiText)
listOfCardapius:insert(nemi2Text)
listOfCardapius:insert(nemi3Text)

	
local function showMenu()
	title = display.newText( "Cardapius", 0, 0, native.systemFont, 32 )
		title:setFillColor( 0 )
		title.x = display.contentWidth * 0.5
		title.y = 30
	subtitle = display.newText("Lista de restaurantes:", 0, 0, native.systemFont, 20 )
		subtitle:setFillColor(0)
		subtitle.x = display.contentWidth * 0.35
		subtitle.y = 80
	scrollCardapius = widget.newScrollView{
		backgroundColor = { 0.8, 0.8, 0.8 },
		top = 100,
		left = 10,
		width = 300,
		height = 400,
		isBounceEnabled = true,
		listener = scrollListener}
	scrollCardapius:insert(listOfCardapius)
end

local function hideMenu()
	title:removeSelf()
	subtitle:removeSelf()
	scrollCardapius:removeSelf()
	listOfCardapius:removeSelf()
	listOfCardapius = display.newGroup()
	listOfCardapius:insert(chiqueiroText)
	listOfCardapius:insert(pizzaText)
end

local button
touchLevel = 1
local function showorhide()
	if touchLevel == 2 then
		button:setLabel("S")
		hideMenu()
		touchLevel = 1
	elseif touchLevel == 1 then
		button:setLabel("H")
		showMenu()
		touchLevel = 2
	end
end

local function submitNew()
	local list = display.newGroup()
	local submitTitle = display.newText( "Submeter restaurante", 0, 0, native.systemFont, 30 )
		submitTitle:setFillColor( 0 )
		submitTitle.x = display.contentWidth * 0.5
		submitTitle.y = 60
	local nameField
	local nameFieldTitle = display.newText("Nome:", 0, 0, native.systemFont, 20 )
	nameFieldTitle:setFillColor(0)
	local function nameListener( event )
		if (event.phase == "ended" or event.phase == "submitted") then
			nome = event.target.text
			print(nome)
		end
	end
		nameField = native.newTextField( 150, 150, 180, 30 )
		nameField.x = 105
		nameField.left = 10
		nameFieldTitle.x = nameField.x - 60
		nameFieldTitle.y = nameField.y - 30
		nameField.inputType = "char"
		nameField:addEventListener( "userInput", nameListener )
	list:insert(nameField)
	list:insert(nameFieldTitle)
	local typeField
	local typeFieldTitle = display.newText("Tipo de comida:", 0, 0, native.systemFont, 20 )
	typeFieldTitle:setFillColor(0)
	local function typeListener( event )
		if (event.phase == "ended" or event.phase == "submitted") then
			tipo = event.target.text
			print(tipo)
		end
	end
		typeField = native.newTextField( 150, 150, 180, 30 )
		typeField.x = 105
		typeField.y = nameField.y + 60
		typeFieldTitle.x = typeField.x - 20
		typeFieldTitle.y = typeField.y - 30
		typeField.inputType = "char"
		typeField:addEventListener( "userInput", typeListener )
	list:insert(typeField)
	list:insert(typeFieldTitle)
	local hourField
	local hourFieldTitle = display.newText("Horário de funcionamento:", 0, 0, native.systemFont, 20 )
	hourFieldTitle:setFillColor(0)
	local function hourListener( event )
		if (event.phase == "ended" or event.phase == "submitted") then
			horario = event.target.text
			print(horario)
		end
	end
		hourField = native.newTextField( 150, 150, 180, 30 )
		hourField.x = 105
		hourField.y = typeField.y + 60
		hourFieldTitle.x = hourField.x + 25
		hourFieldTitle.y = hourField.y - 30
		hourField.inputType = "char"
		hourField:addEventListener( "userInput", hourListener )
	list:insert(hourField)
	list:insert(hourFieldTitle)
	
	local listingField
	local listingFieldTitle = display.newText("Principais pratos:", 0, 0, native.systemFont, 20 )
	listingFieldTitle:setFillColor(0)
	local function listingListener( event )
		if (event.phase == "ended" or event.phase == "submitted") then
			cardapio = event.target.text
			print(cardapio)
		end
	end
		listingField = native.newTextField( 150, 150, 180, 30 )
		listingField.x = 105
		listingField.y = hourField.y + 60
		listingFieldTitle.x = listingField.x - 15
		listingFieldTitle.y = listingField.y - 30
		listingField.inputType = "char"
		listingField:addEventListener( "userInput", listingListener )
	list:insert(listingField)
	list:insert(listingFieldTitle)
	
	local pricingField
	local pricingFieldTitle = display.newText("Preços:", 0, 0, native.systemFont, 20 )
	pricingFieldTitle:setFillColor(0)
	local function pricingListener( event )
		if (event.phase == "ended" or event.phase == "submitted") then
			precos = event.target.text
			print(precos)
		end
	end
		pricingField = native.newTextField( 150, 150, 180, 30 )
		pricingField.x = 105
		pricingField.y = listingField.y + 60
		pricingFieldTitle.x = pricingField.x - 55
		pricingFieldTitle.y = pricingField.y - 30
		pricingField.inputType = "char"
		pricingField:addEventListener( "userInput", pricingListener )
	list:insert(pricingField)
	list:insert(pricingFieldTitle)
end

--[[
button = widget.newButton{
		label="S",
		shape="roundedRect",
		cornerRadius = 7,
		fillColor = { default= { 25, 118, 210, 0.4 }, over= { 1, 87, 155, 0.1 } },
		labelColor = { default={0} },
		width=30, height=30,
		fontSize=26,
		onRelease = showorhide
}
button.x = display.contentWidth*0.95
button.y = display.contentHeight - 20
--]]

showMenu()