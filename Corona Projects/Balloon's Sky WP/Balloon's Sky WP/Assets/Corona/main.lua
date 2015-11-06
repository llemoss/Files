-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------
math.randomseed( os.time() )
pixelFont 			 = "Assets/Corona/alterebro-pixel-font.ttf#Alterebro Pixel Font"
local physics 		 = require("physics")
local widget 		 = require ("widget")
local loadsave 		 = require( "loadsave" ) 
system.activate("multitouch")
language 			 = system.getPreference( "ui", "language" )

halfW 				= display.contentWidth*0.5
halfH 				= display.contentHeight*0.5
bkg 				= display.newImage("nuvem1.png", halfW, halfH)

local musicStream
local bombPop
local balloonPop
local bonusPop
muted 				= false
vibrating 			= true
level				= "easy"
-- TUTORIAL
greenTutorial 		= true
yellowTutorial 		= true
bombTutorial 		= true
blackbombTutorial 	= true
greenTutorialTimed 	= true
yellowTutorialTimed = true
purpleTutorial		= true
classicTutorial		= true
toastActive 		= false

gameSettings = loadsave.loadTable("settings.json")
if gameSettings == nil then
			gameSettings = {
				muted = false,
				vibrating = true,
				level = "easy",
				greenTutorial = true,
				yellowTutorial = true,
				bombTutorial = true,
				blackbombTutorial = true,
				greenTutorialTimed = true,
				yellowTutorialTimed = true,
				missedTutorial = true,
				purpleTutorial = true,
				classicTutorial = true,}
			loadsave.saveTable(gameSettings, "settings.json")
			gameSettings = loadsave.loadTable("settings.json")
end

--------------------------------------------------------------Misc var
local scoreText
local missedText
local tutorialToast
local levelPlayed
count = 0
balloonImage 		= "red_balloon.png"
timesReplayed	 	= 0
quantBalloons 		= 1
delayBonus 			= 200
multQuant 			= 25
objectsCreated 		= 0
score 				= 0
initGravity 		= 4
maxBalloons         = 4
balloonsMissed 		= 0
gameoverbyblackbomb = 0
blueballoonPopped 	= 0
balloonsPopped 		= 0
bombPopped			= 0
blackbombPopped 	= 0
bombChance 			= 9
blackbombChance 	= 150
greenChance 		= 90
yellowChance 		= 80
purpleChance 		= 240
purpleballoonPopped = 0
yellowballoonPopped = 0
seconds 			= 60
startY 				= -400
maxScore 			= score
timereplay 			= {}
objectsDestroyed	= 0

unusedWidth			= display.actualContentWidth - display.contentWidth
unusedHeight		= display.actualContentHeight - display.contentHeight
left				= 0 - unusedWidth/2
top 				= 0 - unusedHeight/2
right 				= display.contentWidth + unusedWidth/2
bottom 				= display.contentHeight + unusedHeight/2
size 				= display.viewableContentHeight/15
buttonTextSize 		= display.viewableContentWidth/20
width			    = display.viewableContentWidth - display.viewableContentWidth/100

--------------------------------------------------------------end of misc variables
----- TRANSLATIONS -----
boardsTranslated = {
	["English"] 	= "Leaderboards!",
	["português"] 	= "Placares!"}
achievementsTranslated = {
	["English"] 	= "Achievements!",
	["português"] 	= "Conquistas!"}
ratingTranslated = {
	["English"] 	= "Review it!",
	["português"] 	= "Avalie!"}
gameoverTranslated = {
	["English"] 	= "    Game over!\n\nMissed: %d\nMax score: %d\nFinal score: %d",
	["português"] 	= "    Fim do jogo!\n\nPerdidos: %d\nMaior placar: %d\nPlacar final: %d",
}
missedTranslated = {
	["English"] 	= "Missed:",
	["português"] 	= "Perdidos:",
}
scoreTranslated = {
	["English"] 	= "Score:",
	["português"] 	= "Placar:",
}
timeTranslated = {
	["English"] 	= "Time:",
	["português"] 	= "Tempo:",
}
welcome2Translated = {
	["English"] 	= "Red ones = +1 point\nGreen ones = +50 points\nYellow ones = 0 missed\nRed bombs = quarter score!\nBlack bombs or missing 10 balloons\nwill end the game!\n",
	["português"] 	= "Vermelhos = +1 ponto\nVerdes = +50 pontos\nAmarelos = 0 errados\nBombas vermelhas = um quarto do placar!\nBombas pretas ou errar dez acabam o jogo!\n",
}
welcome2TimedTranslated = {
	["English"] 	= "Red ones = +5 points\nGreen ones = +100 points\nYellow ones = +10 seconds\nRed bombs = quarter score!\nBlack bombs or reaching 0 seconds\nwill end the game!\n",
	["português"] 	= "Vermelhos = +5 pontos\nVerdes = +100 pontos\nAmarelos = +10 segundos\nBombas vermelhas = um quarto do placar!\nBombas pretas ou zerar o tempo!\n",
}
greenTutorialText = {
	["English"] = "Green balloons will add\n+50 points to your score!",
	["português"] = "Balões verdes adicionam\n+50 pontos ao placar!",
}
yellowTutorialText = {
	["English"] = "Yellow balloons can\nreset your missed count!",
	["português"] = "Balões amarelos resetam\na quantia de perdidos!",
}
bombTutorialText = {
	["English"] = "Bombs will decrease\none quarter of your score!" ,
	["português"] = "Bombas diminuem seu\nplacar em um quarto!",
}
blackbombTutorialText = {
	["English"] = "Black bombs will set your\nscore to zero!",
	["português"] = "Bombas pretas zerarão\no placar!",
}
greenTutorialTextTimed = {
	["English"] = "Green balloons will add\n+100 points to your score!",
	["português"] = "Balões verdes adicionam\n+100 pontos ao placar!",
}
yellowTutorialTextTimed = {
	["English"] = "Yellow balloons can\nadd 10 seconds!",
	["português"] = "Balões amarelos adicionam\nmais 10 segundos!",
}
purpleTutorialText = {
	["English"] = "Purple balloons get\nback your score!",
	["português"] = "Balões roxos recuperam\nseu placar!",
}
missedTutorialText = {
	["English"] = "And missing 10 balloons\nwill end the game!",
	["português"] = "E perder dez balões\nfinaliza o jogo!",
}
welcome1Translated = {
	["English"] 	= "logoballoon1.png",
	["português"] 	= "logoballoon2.png",
}
playTranslated = {
	["English"] 	= "Start",
	["português"] 	= "Jogar",
}
creditsTranslated = {
	["English"] 	= "v2.7.1\n\nProducer and composer\nGildásio Filho - gildasiogx@gmail.com\n\nArtwork\nJulia Gudino - juliahbgudino@gmail.com\n\nAttribution to balloon's \npop sound:\nhttps://goo.gl/noA3Qk\n\nBalloon's Sky is licensed\nunder the Creative Commons\nattribution, non commercial\nand no derivatives 4.0 international\nlicense. To view a copy of this\nlicense, see:\nhttp://goo.gl/TMTQGk\n",
	["português"] 	= "v2.7.1\n\nProdutor e compositor\nGildásio Filho - gildasiogx@gmail.com\n\nArtwork\nJulia Gudino - juliahbgudino@gmail.com\n\nAtribuição ao som do balão:\nhttps://goo.gl/noA3Qk\n\nBalloon's Sky é licenciado sobre a\nCreative Commons internacional 4.0\nde atribuição, não comercial e\nsem derivados. Para ver uma cópia\nda licença, veja:\nhttp://goo.gl/TMTQGk\n",}
submitTranslated = {
	["English"] 	= "Submit score!",
	["português"] 	= "Submeter placar!",}
credBtnTranslated = {
	["English"] 	= "Credits",
	["português"] 	= "Créditos",}
muteTranslated = {
	["English"] 	= "Sound: ON",
	["português"] 	= "Som: ON",}
unmuteTranslated = {
	["English"] 	= "Sound: OFF",
	["português"] 	= "Som: OFF",}
vibrateTranslated = {
	["English"] 	= "Vibration: ON",
	["português"] 	= "Vibração: ON",}
unvibrateTranslated = {
	["English"] 	= "Vibration: OFF",
	["português"] 	= "Vibração: OFF",}
easyTranslated = {
	["English"] 	= "Type: HARD",
	["português"] 	= "Modo: DIFÍCIL",}
hardTranslated = {
	["English"] 	= "Type: EASY",
	["português"] 	= "Modo: FÁCIL",}
timedTranslated = {
	["English"] 	= "Type: TIMED",
	["português"] 	= "Modo: TEMPO",}
classicTranslated = {
	["English"] 	= "Type: CLASSIC",
	["português"] 	= "Modo: CLÁSSICO",
}
classicTutorialText = {
	["English"] = "No extras, no bombs!\nEnjoy the hardest type!\nMissing balloons\ndecrease your score!",
	["português"] = "Sem extras, sem bombas!\nApenas velocidade!\nPerder balões subtrai\num ponto!",
}
halpTranslated = {
	["English"] = "Help the developer by\ntouching the ads!",
	["português"] = "Ajude o desenvolvedor\ntocando nos anúncios!",}
	----- END OF TRANSLATIONS -----

if language ~= "português" then
	language = "English"
end

--------------------------------------------------------------begin of Google Play stuff

----There's no Google Play Stuff :D
--------------------------------------------------------------end of Google Play stuff
local function balloonTouched(event)
	if(event.phase == "began") then
		Runtime:removeEventListener("enterFrame", event.self)
		event.target:removeSelf()
		balloonStream = audio.play(balloonPop)
		if vibration == true then system.vibrate() end
		balloonsPopped = balloonsPopped + 1
		older = score
		olderMax = maxScore
		if level ~= "timed" then
			score = score + 1
		else
			score = score + 5
		end
		if score > older then
			maxScore = score
		end
		if maxScore < olderMax then
			maxScore = olderMax
		end
		scoreText.text = string.format(scoreTranslated[language] .. " %d", score)
	end
end

local function purpleballoonTouched(event)
	if(event.phase == "began") then
		Runtime:removeEventListener("enterFrame", event.self)
		event.target:removeSelf()
		bonusStream = audio.play(bonusPop)
		if vibration == true then system.vibrate()	end
		balloonsPopped = balloonsPopped + 1
		purpleballoonPopped = purpleballoonPopped + 1
		older = score
		olderMax = maxScore
		if score > older then
			maxScore = score
		end
		if maxScore < olderMax then
			maxScore = olderMax
		end
		if level == "easy" or level == "hard" then
			score = maxScore
		else
			score = maxScore
		end
		scoreText.text = string.format(scoreTranslated[language] .. " %d", score)
	end
end

local function bombTouched(event)
	if(event.phase == "began") then
		Runtime:removeEventListener("enterFrame", event.self)
		event.target:removeSelf()
		if vibration == true then system.vibrate() end
		bombStream = audio.play(bombPop)
		older = score
		olderMax = maxScore
		score = math.floor(score*0.75)
		bombPopped = bombPopped + 1
		if score > older then
			maxScore = score
		end
		if maxScore < olderMax then
			maxScore = olderMax
		end
		scoreText.text = string.format(scoreTranslated[language] .. " %d", score)
	end
end

local function bombzeroTouched(event)
	if(event.phase == "began") then
		Runtime:removeEventListener("enterFrame", event.self)
		event.target:removeSelf()
		bombStream = audio.play(bombPop)
		if vibration == true then system.vibrate() end
		if (score > 0) then
			older = score
			olderMax = maxScore
			if score > older then
				maxScore = score
			end
			if maxScore < olderMax then
				maxScore = olderMax
			end
			score = 0
			blackbombPopped = blackbombPopped + 1
			scoreText.text = string.format(scoreTranslated[language] .. " %d", score)
		end
	end
end

local function blueballoonTouched(event)
	if(event.phase == "began") then
		Runtime:removeEventListener("enterFrame", event.self)
		event.target:removeSelf()
		bonusStream = audio.play(bonusPop)
		if vibration == true then system.vibrate() end
		blueballoonPopped = blueballoonPopped + 1
		balloonsPopped = balloonsPopped + 1
		older = score
		olderMax = maxScore
		if level ~= "timed" then
			score = score + 50
		else
			score = score + 100
		end
		if score > older then
			maxScore = score
		end
		if maxScore < olderMax then
			maxScore = olderMax
		end
		scoreText.text = string.format(scoreTranslated[language] .. " %d", score)
	end
end

local function yellowballoonTouched(event)
	if(event.phase == "began") then
		Runtime:removeEventListener("enterFrame", event.self)
		event.target:removeSelf()
		bonusStream = audio.play(bonusPop)
		if vibration == true then system.vibrate() end
		balloonsPopped = balloonsPopped + 1
		if balloonsMissed == 0 then
			yellowballoonPopped = 0
		end
		if balloonsMissed > 0 then
			yellowballoonPopped = yellowballoonPopped + 1
		end
		if level ~= "timed" then
			balloonsMissed = 0
			missedText.text = string.format(missedTranslated[language] .. " %d/10", balloonsMissed)
		else
			seconds = seconds + 10
			timeText.text = string.format(timeTranslated[language] .. " %d", seconds)
		end
		scoreText.text = string.format(scoreTranslated[language] .. " %d", score)
		
	end
end

local function offscreenBalloon(self, event)
	if (self.y == nil) then
		return
	end
	if (self.y > display.contentHeight*1.5) then
		Runtime:removeEventListener("enterFrame", self)
		self:removeSelf()
		if balloonsPopped >= 1 and (level == "easy" or level == "hard") then
			balloonsMissed = balloonsMissed + 1
			missedText.text = string.format(missedTranslated[language] .. " %d/10", balloonsMissed)
		elseif balloonsPopped >= 1 and level == "timed" then
			balloonsMissed = balloonsMissed + 1
			if seconds > 0 then
				seconds = seconds - 1
			end
			timeText.text = string.format(timeTranslated[language] .. " %d", seconds)
		elseif balloonsPopped >= 1 and level == "classic" then
			balloonsMissed = balloonsMissed + 1
			if score > 0 then
				score = score - 1
			end
			scoreText.text = string.format(scoreTranslated[language] .. " %d", score)
			missedText.text = string.format(missedTranslated[language] .. " %d/10", balloonsMissed)
		else
			objectsCreated = 0
		end
		objectsDestroyed = objectsDestroyed + 1
	end
end

local function offscreen(self, event)
	if (self.y == nil) then
		return
	end
	if (self.y > display.contentHeight*1.3) then
		Runtime:removeEventListener("enterFrame", self)
		self:removeSelf()
		objectsDestroyed = objectsDestroyed + 1
	end
end

local function addNewBallonOrBomb()
	if (math.random(1, bombChance) == 1) then
		bomb = display.newImage("bombzero.png", math.random(display.contentWidth*0.2, display.contentWidth*0.85) - math.random(-20, 20), startY + 100, true)
		physics.addBody(bomb, {radius = 60, friction = 0, bounce = 0, isSensor=true})
		bomb.enterFrame = offscreen
		Runtime:addEventListener("enterFrame", bomb)
		bomb:addEventListener("touch", bombTouched)
		objectsCreated = objectsCreated + 1
		return bomb
	elseif (math.random(1, blackbombChance) == 1) then
		local bombzero = display.newImage("bomb.png", math.random(display.contentWidth*0.2, display.contentWidth*0.85), -300, true)
		physics.addBody(bombzero, {radius = 60, friction = 0, bounce = 0, isSensor=true})
		bombzero.enterFrame = offscreen
		Runtime:addEventListener("enterFrame", bombzero)
		bombzero:addEventListener("touch", bombzeroTouched)
		objectsCreated = objectsCreated + 1
	elseif (math.random(1, greenChance) == 1) then
		local blueballoon = display.newImage("blue_balloon.png", math.random(display.contentWidth*0.2, display.contentWidth*0.85), -700, true)
		physics.addBody(blueballoon, {radius = 95, friction = 0, bounce = 0, isSensor=true})
		blueballoon.enterFrame = offscreenBalloon
		Runtime:addEventListener("enterFrame", blueballoon)
		blueballoon:addEventListener("touch", blueballoonTouched)
		objectsCreated = objectsCreated + 1
	elseif (math.random(1, yellowChance) == 1) then
		local yellowballoon = display.newImage("purple_balloon.png", math.random(display.contentWidth*0.2, display.contentWidth*0.85), -500, true)
		physics.addBody(yellowballoon, {radius = 95, friction = 0, bounce = 0, isSensor=true})
		yellowballoon.enterFrame = offscreen
		Runtime:addEventListener("enterFrame", yellowballoon)
		yellowballoon:addEventListener("touch", yellowballoonTouched)
		objectsCreated = objectsCreated + 1
	elseif (math.random(1, purpleChance) == 1) then
		local purpleballoon = display.newImage("purple_balloon2.png", math.random(display.contentWidth*0.2, display.contentWidth*0.85), -700, true)
		physics.addBody(purpleballoon, {radius = 95, friction = 0, bounce = 0, isSensor=true})
		purpleballoon.enterFrame = offscreenBalloon
		Runtime:addEventListener("enterFrame", purpleballoon)
		purpleballoon:addEventListener("touch", purpleballoonTouched)
		objectsCreated = objectsCreated + 1
	else
		balloon = display.newImage("red_balloon.png", math.random(display.contentWidth*0.2, display.contentWidth*0.85), startY - math.random(-100, -50), true)
		physics.addBody(balloon, {radius = 100, friction = 0, bounce = 0, isSensor=true})
		balloon.enterFrame = offscreenBalloon
		Runtime:addEventListener("enterFrame", balloon)
		balloon:addEventListener("touch", balloonTouched)
		objectsCreated = objectsCreated + 1
		return balloon
	end
end

local function verif()
	print("Funcao de verifificacao geral em andamento..")
	print("Objetos criados:", objectsCreated)
	print("Objetos destruidos:", objectsDestroyed)
	-- FOR TIMED MODE
	if level == "timed" and objectsCreated > 4 then
		if seconds < 0 or seconds == 0 then
			timeText.text = string.format(timeTranslated[language] .. " %d", 0)
		else
			seconds = seconds - 1
		end
		timeText.text = string.format(timeTranslated[language] .. " %d", seconds)
	end
	--
	-- GRAVITY IMPROVE
	if (objectsCreated%10) == 0 and level ~= "classic" then
		physics.setGravity(0, initGravity + 0.5)
		print("Gravidade aumentada em 0.5")
	elseif objectsCreated%2 == 0 then
		physics.setGravity(0, initGravity + 1)
		print("Gravidade aumentada em 2")
	end
	--
	-- DIFFICULTY IMPROVE
	if (objectsCreated > multQuant and quantBalloons < maxBalloons) then
		delay = delay + delayBonus + math.random(10, 50)
		timereplay[quantBalloons] = timer.performWithDelay(delay, addNewBallonOrBomb, 0)
		quantBalloons = quantBalloons + 1
		bombChance = bombChance - 1
		if level == "easy" then
			startY = startY - 50
		elseif level == "hard" or level == "timed" then
			startY = startY - 100
		elseif ((level == "hard" or level == "timed") and quantBalloons == 3) then
			startY = startY - 200
		end
		multQuant = math.floor(multQuant*2.5)
		print("Quantidade de baloes atual:", quantBalloons)
		print("Delay extra:", delay)
		print("Multiplier:", multQuant)
	end
	
	if level == "classic" and objectsCreated > multQuant then
		if delay > 300 then
		delay = delay - delayBonus
		end
		startY = startY - 300
		multQuant = math.floor(multQuant*2)
		print("Quantidade de baloes atual:", quantBalloons)
		print("Delay extra:", delay)
		print("Multiplier:", multQuant)
	end
	--
	-- GAMEOVER VERIF
	if (balloonsMissed >= 10 and gameover == false and level ~= "timed") or (seconds <= 0 and gameover == false) then
		timer.cancel(timereplay[0])
		timer.cancel(timerverif)
		bkg = display.newImage("nuvem2.png", halfW, halfH)
		scoreText:removeSelf()
		if level == "easy" or level == "hard" then
			missedText:removeSelf()
			if missedTutorial == true and balloonsMissed >= 10 and toastActive == false then
				toastActive = true
				print("Iniciando tutorial")
				tutorialToast = widget.newButton{
					label=missedTutorialText[language],
					shape="roundedRect",
					cornerRadius = 6,
					fillColor = { default= { 96, 125, 139, 0.1 }, over= { 96, 125, 139, 0.2 } },
					labelColor = { default={ 1 }},
					--labelColor = { default={255}, over={128} },
					--default="button.png",
					--over="button-over.png",
					width=180, height=60,
					font=pixelFont,
					fontSize=25,
				}
				tutorialToast.x = display.contentWidth*0.5
				tutorialToast.y = display.contentHeight*0.5 - 200
				count = objectsCreated
				missedTutorial = false
			end
		elseif level == "timed" then
			timeText:removeSelf()
		end
		overText = display.newText(string.format(gameoverTranslated[language], balloonsMissed, maxScore, score), halfW, halfH, pixelFont, 40)
		physics.stop()
		gameover = true
		print("gameover = true")
		audio.fade( { channel=1, time=4000, volume=0.0 } )
	end
	--
	-- TUTORIAL FOR EASY AND HARD
	if greenTutorial == true and blueballoonPopped >= 1 and toastActive == false and level ~= "timed" then
			toastActive = true
			print("Iniciando tutorial")
			tutorialToast = widget.newButton{
				label=greenTutorialText[language],
				shape="roundedRect",
				cornerRadius = 6,
				fillColor = { default= { 96, 125, 139, 0.1 }, over= { 96, 125, 139, 0.2 } },
				labelColor = { default={ 1 }},
				--labelColor = { default={255}, over={128} },
				--default="button.png",
				--over="button-over.png",
				width=180, height=60,
				font=pixelFont,
				fontSize=25,
			}
			tutorialToast.x = display.contentWidth*0.5
			tutorialToast.y = display.contentHeight*0.5 - 200
			count = objectsCreated
			greenTutorial = false
	end
	if greenTutorialTimed == true and blueballoonPopped >= 1 and toastActive == false and level == "timed" then
			toastActive = true
			print("Iniciando tutorial")
			tutorialToast = widget.newButton{
				label=greenTutorialTextTimed[language],
				shape="roundedRect",
				cornerRadius = 6,
				fillColor = { default= { 96, 125, 139, 0.1 }, over= { 96, 125, 139, 0.2 } },
				labelColor = { default={ 1 }},
				--labelColor = { default={255}, over={128} },
				--default="button.png",
				--over="button-over.png",
				width=180, height=60,
				font=pixelFont,
				fontSize=25,
			}
			tutorialToast.x = display.contentWidth*0.5
			tutorialToast.y = display.contentHeight*0.5 - 200
			count = objectsCreated
			greenTutorialTimed = false
	end
	if yellowTutorial == true and yellowballoonPopped >= 1 and toastActive == false and level ~= "timed" then
			toastActive = true
			print("Iniciando tutorial")
			tutorialToast = widget.newButton{
				label=yellowTutorialText[language],
				shape="roundedRect",
				cornerRadius = 6,
				fillColor = { default= { 96, 125, 139, 0.1 }, over= { 96, 125, 139, 0.2 } },
				labelColor = { default={ 1 }},
				--labelColor = { default={255}, over={128} },
				--default="button.png",
				--over="button-over.png",
				width=180, height=60,
				font=pixelFont,
				fontSize=25,
			}
			tutorialToast.x = display.contentWidth*0.5
			tutorialToast.y = display.contentHeight*0.5 - 200
			count = objectsCreated
			yellowTutorial = false
	end
	if yellowTutorialTimed == true and yellowballoonPopped >= 1 and toastActive == false and level == "timed" then
			toastActive = true
			print("Iniciando tutorial")
			tutorialToast = widget.newButton{
				label=yellowTutorialTextTimed[language],
				shape="roundedRect",
				cornerRadius = 6,
				fillColor = { default= { 96, 125, 139, 0.1 }, over= { 96, 125, 139, 0.2 } },
				labelColor = { default={ 1 }},
				--labelColor = { default={255}, over={128} },
				--default="button.png",
				--over="button-over.png",
				width=160, height=60,
				font=pixelFont,
				fontSize=25,
			}
			tutorialToast.x = display.contentWidth*0.5
			tutorialToast.y = display.contentHeight*0.5 - 200
			count = objectsCreated
			yellowTutorialTimed = false
	end
	if bombTutorial == true and bombPopped >= 1 and toastActive == false then
			toastActive = true
			print("Iniciando tutorial")
			tutorialToast = widget.newButton{
				label=bombTutorialText[language],
				shape="roundedRect",
				cornerRadius = 6,
				fillColor = { default= { 96, 125, 139, 0.1 }, over= { 96, 125, 139, 0.2 } },
				labelColor = { default={ 1 }},
				--labelColor = { default={255}, over={128} },
				--default="button.png",
				--over="button-over.png",
				width=185, height=60,
				font=pixelFont,
				fontSize=25,
			}
			tutorialToast.x = display.contentWidth*0.5
			tutorialToast.y = display.contentHeight*0.5 - 200
			count = objectsCreated
			bombTutorial = false
	end
	if blackbombTutorial == true and blackbombPopped >= 1 and toastActive == false then
			toastActive = true
			print("Iniciando tutorial")
			tutorialToast = widget.newButton{
				label=blackbombTutorialText[language],
				shape="roundedRect",
				cornerRadius = 6,
				fillColor = { default= { 96, 125, 139, 0.1 }, over= { 96, 125, 139, 0.2 } },
				labelColor = { default={ 1 }},
				--labelColor = { default={255}, over={128} },
				--default="button.png",
				--over="button-over.png",
				width=185, height=60,
				font=pixelFont,
				fontSize=25,
			}
			tutorialToast.x = display.contentWidth*0.5
			tutorialToast.y = display.contentHeight*0.5 - 200
			count = objectsCreated
			blackbombTutorial = false
	end
	if purpleTutorial == true and purpleballoonPopped >= 1 and toastActive == false then
			toastActive = true
			print("Iniciando tutorial")
			tutorialToast = widget.newButton{
				label=purpleTutorialText[language],
				shape="roundedRect",
				cornerRadius = 6,
				fillColor = { default= { 96, 125, 139, 0.1 }, over= { 96, 125, 139, 0.2 } },
				labelColor = { default={ 1 }},
				--labelColor = { default={255}, over={128} },
				--default="button.png",
				--over="button-over.png",
				width=180, height=60,
				font=pixelFont,
				fontSize=25,
			}
			tutorialToast.x = display.contentWidth*0.5
			tutorialToast.y = display.contentHeight*0.5 - 200
			count = objectsCreated
			purpleTutorial = false
	end
	if classicTutorial == true and balloonsPopped >= 1 and level == "classic" and toastActive == false then
			toastActive = true
			print("Iniciando tutorial")
			tutorialToast = widget.newButton{
				label=classicTutorialText[language],
				shape="roundedRect",
				cornerRadius = 6,
				fillColor = { default= { 96, 125, 139, 0.1 }, over= { 96, 125, 139, 0.2 } },
				labelColor = { default={ 1 }},
				--labelColor = { default={255}, over={128} },
				--default="button.png",
				--over="button-over.png",
				width=210, height=100,
				font=pixelFont,
				fontSize=25,
			}
			tutorialToast.x = display.contentWidth*0.5
			tutorialToast.y = display.contentHeight*0.5 - 170
			count = objectsCreated
			classicTutorial = false
	end
	if objectsCreated >= count + 7 and toastActive == true then
		tutorialToast:removeSelf()
		toastActive = false
	end
	--
end

local muteBtn
touchMute = 1
local function muteUnmute()
	if touchMute == 2 then
		muteBtn:setLabel(muteTranslated[language])
		touchMute = 1
		print("Desmutado")
		muted = false
	elseif touchMute == 1 then
		muteBtn:setLabel(unmuteTranslated[language])
		touchMute = 2
		print("Mutado")
		muted = true
	end
end

local vibrateBtn
touchVibr = 1
local function vibratingFunc()
	if touchVibr == 2 then
		vibrateBtn:setLabel(vibrateTranslated[language])
		touchVibr = 1
		print("Vibracao ligada")
		vibrating = true
	elseif touchVibr == 1 then
		vibrateBtn:setLabel(unvibrateTranslated[language])
		touchVibr = 2
		print("Vibracao desligada")
		vibrating = false
	end
end

local levelBtn
touchLevel = 1
local function changingDifficulty()
	if touchLevel == 4 then
		levelBtn:setLabel(classicTranslated[language])
		touchLevel = 1
		print("Classico")
		level = "classic"
	elseif touchLevel == 3 then
		levelBtn:setLabel(timedTranslated[language])
		touchLevel = 4
		print("Tempo")
		level = "timed"
	elseif touchLevel == 2 then
		levelBtn:setLabel(easyTranslated[language])
		touchLevel = 3
		print("Dificil")
		level = "hard"
	elseif touchLevel == 1 then
		levelBtn:setLabel(hardTranslated[language])
		touchLevel = 2
		print("Facil")
		level = "easy"
	end
end

local function game()
		gameover = false
		levelPlayed = level
		delay = 1000
		print("gameover = false")
		replayConfirm = false
		print("replayConfirm =  false")
		if muted == false then
			musicStream = audio.loadStream("music.wav")
			bombPop = audio.loadSound("bomb.wav")
			balloonPop = audio.loadSound("balloon.wav") --Credits to https://goo.gl/noA3Qk
			bonusPop = audio.loadSound("bonus.wav")
			music = audio.play(musicStream, {channel = 1, loops = -1})
			audio.setMaxVolume(0.05, {channel=0})
			audio.setMaxVolume(0.5, {channel=1})
		end
		if vibrating == false then
			vibration = false
		else
			vibration = true
		end
		if level == "hard" then
			startY = -700
			maxBalloons = 5
			bombChance = 8
			timereplay[quantBalloons] = timer.performWithDelay(delay, addNewBallonOrBomb, 0)
			quantBalloons = quantBalloons + 1
			balloonImage = "red_balloon" .. quantBalloons .. ".png"
			multQuant = math.floor(multQuant*2.5) + quantBalloons
		elseif level == "easy" then
			bombChance = 12
			startY = -400
			maxBalloons = 4
			quantBalloons = 1
		elseif level == "timed" then
			timeText = display.newText(string.format(timeTranslated[language] .. " %d", seconds), halfW+100, 25, pixelFont, 30)
			startY = -800
			maxBalloons = 5
			bombChance = 8
			timereplay[quantBalloons] = timer.performWithDelay(delay, addNewBallonOrBomb, 0)
			quantBalloons = quantBalloons + 1
			multQuant = quantBalloons + 2
		else
			timereplay[quantBalloons] = timer.performWithDelay(delay, addNewBallonOrBomb, 0)
			initGravity = 6
			bombChance = 100000
			greenChance = 100000
			blackbombChance = 100000
			yellowChance = 100000
			purpleChance = 100000
			maxBalloons = 1
			startY = -800
			multQuant = 5
			delayBonus = 100
		end
		scoreText = display.newText(string.format(scoreTranslated[language] .. " %d", score), halfW-100, 25, pixelFont, 30)
		if level ~= "timed" then
		missedText = display.newText(string.format(missedTranslated[language] .. " %d/10", balloonsMissed), halfW+100, 25, pixelFont, 30)
		end
		physics.start()
		physics.setGravity(0, initGravity)
		print("Gravity =", initGravity)
		if (gameover == false) then
			addNewBallonOrBomb()
			verif()
			timereplay[0] = timer.performWithDelay(delay + 200, addNewBallonOrBomb, 0)
			timerverif = timer.performWithDelay(1000, verif, 0)
			print("Timers acionados")
		else
			physics.pause()
		end
		
	end

local function playGame()
	playBtn:removeSelf()
	credBtn:removeSelf()
	welcomeText:removeSelf()
	muteBtn:removeSelf()
	vibrateBtn:removeSelf()
	levelBtn:removeSelf()
	gameSettings = {
			muted,
			vibrating,
			level,
			greenTutorial,
			yellowTutorial,
			bombTutorial,
			blackbombTutorial,
			greenTutorialTimed,
			yellowTutorialTimed,
			missedTutorial,
			purpleTutorial,
			classicTutorial,
		}
	loadsave.saveTable(gameSettings, "settings.json")
	game()
end

local function replayGame()
		if timesReplayed >= 1 then
			ratingButton:removeSelf()
		end
		timesReplayed = timesReplayed + 1
		objectsCreated = 0
		score = 0
		maxScore = 0
		initGravity = 4
		multQuant = 25
		delayBonus = 200
		balloonsMissed = 0
		gameoverbyblackbomb = 0
		blueballoonPopped = 0
		balloonsPopped = 0
		purpleballoonPopped = 0
		yellowballoonPopped = 0
		blackbombPopped = 0
		bombPopped = 0
		bombChance = 9
		blackbombChance = 150
		greenChance = 90
		yellowChance = 80
		purpleChance = 240
		seconds = 60
		balloonImage = "red_balloon.png"
		for k, v in pairs(timereplay) do
			timer.cancel(v)
		end
		quantBalloons = 1
		replayConfirm = true
		gameover = false
		print("replayConfirm & gameover = false")
		print("Deletando botao de replay e reiniciando o jogo")
		overText:removeSelf()
		reBtn:removeSelf()
		levelBtn:removeSelf()
		game()
		if missedTutorial == false and toastActive == true then
			tutorialToast:removeSelf()
			toastActive = false
		end
		audio.fade( { channel=1, time=1500, volume=0.5 } )
		audio.rewind( { channel=1 } )
end

local function credits()
	onCredits = true
	welcomeText:removeSelf()
	credBtn:removeSelf()
	muteBtn:removeSelf()
	vibrateBtn:removeSelf()
	levelBtn:removeSelf()
	playBtn.x = display.contentWidth*0.5
	playBtn.y = display.contentHeight - 70
	welcomeText = widget.newButton{
		label=creditsTranslated[language],
		labelColor = { default={255}, over={255}},
		font=pixelFont,
		fontSize=26,
		textOnly=true
	}
	welcomeText.x = display.contentWidth*0.5
	welcomeText.y = display.contentHeight*0.5 - 30
end

local function openReview()
	system.openURL("https://play.google.com/store/apps/details?id=com.gildasiozeth.balloons")
end

local function gameoverVerif()
	print("Verificando se gameover & replayConfirm = true...")
	if (gameover == true and replayConfirm == true) then
		print("Criando botao de replay")
		reBtn = widget.newButton{
		label="Replay?",
		shape="roundedRect",
		cornerRadius = 7,
		fillColor = { default= { 25, 118, 210, 0.4 }, over= { 1, 87, 155, 0.1 } },
		--labelColor = { default={255}, over={128} },
		labelColor = { default={255} },
		--default="button.png",
		--over="button-over.png",
		width=110, height=30,
		font=pixelFont,
		fontSize=26,
		onRelease = replayGame
		}
		reBtn.x = display.contentWidth*0.5 + 57
		reBtn.y = display.contentHeight - 125
		levelBtn = widget.newButton{
		label=hardTranslated[language],
		labelColor = { default={255, 255, 255, 1} },
		--default="button.png",
		--over="button-over.png",
		shape="roundedRect",
		cornerRadius = 6,
		fillColor = { default= { 25, 118, 210, 0.4 }, over= { 1, 87, 155, 0.1 } },
		width=110, height=30,
		font=pixelFont,
		fontSize=26,
		onRelease = changingDifficulty
		}
		plzHelpToast = widget.newButton{
				width=185, height=47,
				label = halpTranslated[language],
				--labelColor = { default={255}, over={128} },
				shape="roundedRect",
				cornerRadius = 7,
				labelColor = { default={255} },
				fillColor = { default= { 25, 118, 210, 0.4 }, over= { 1, 87, 155, 0.1 } },
				font=pixelFont,
				fontSize=27,
				onRelease = plzHelpFunction,
			}
		levelBtn.x = display.contentWidth*0.5 - 57
		levelBtn.y = display.contentHeight - 125
		plzHelpToast.x = display.contentWidth*0.5
		plzHelpToast.y = display.contentHeight*0.5 - 160
		plzHelpDeleted = false
		if level == "hard" then
			levelBtn:setLabel(easyTranslated[language])
			touchLevel = 3
		elseif level == "easy" then
		    levelBtn:setLabel(hardTranslated[language])
			touchLevel = 2
		elseif level == "timed" then
			levelBtn:setLabel(timedTranslated[language])
			touchLevel = 4
		else
			levelBtn:setLabel(classicTranslated[language])
			touchLevel = 1
		end
		gameSettings = {
			muted,
			vibrating,
			level,
			greenTutorial,
			yellowTutorial,
			bombTutorial,
			blackbombTutorial,
			greenTutorialTimed,
			yellowTutorialTimed,
			missedTutorial,
			purpleTutorial,
			classicTutorial,
		}
		loadsave.saveTable(gameSettings, "settings.json")
	end
end

local function replayVerif()
	print("Executando verificacao de fim de jogo")
	if ((gameover == true) and (replayConfirm == false)) then
		print("Acabou o jogo e o replay foi autorizado, iniciando..")
		replayConfirm = true
		print("replayConfirm = true")
		gameoverVerif()
	end
end

local function initGame()
	gameSettings = loadsave.loadTable("settings.json")
	welcomeText = display.newImage(welcome1Translated[language], 1, 1, true)
	playBtn = widget.newButton{
		label=playTranslated[language],
		shape="roundedRect",
		cornerRadius = 7,
		labelColor = { default={255} },
		fillColor = { default= { 25, 118, 210, 0.3 }, over= { 1, 87, 155, 0.1 } },
		--labelColor = { default={255}, over={128} },
		--default="button.png",
		--over="button-over.png",
		width=110, height=30,
		font=pixelFont,
		fontSize=37,
		onRelease = playGame
	}
	credBtn = widget.newButton{
		label=credBtnTranslated[language],
		shape="roundedRect",
		cornerRadius = 7,
		labelColor = { default={255} },
		fillColor = { default= { 25, 118, 210, 0.4 }, over= { 1, 87, 155, 0.1 } },
		--labelColor = { default={255}, over={128} },
		--default="button.png",
		--over="button-over.png",
		width=110, height=25,
		font=pixelFont,
		fontSize=25,
		onRelease = credits
	}
	muteBtn = widget.newButton{
		label=muteTranslated[language],
		shape="roundedRect",
		cornerRadius = 7,
		labelColor = { default={255} },
		fillColor = { default= { 25, 118, 210, 0.4 }, over= { 1, 87, 155, 0.1 } },
		---labelColor = { default={255}, over={128} },
		---default="button.png",
		---over="button-over.png",
		width=110, height=26,
		font=pixelFont,
		fontSize=22,
		onRelease = muteUnmute
	}
	vibrateBtn = widget.newButton{
		label=vibrateTranslated[language],
		shape="roundedRect",
		cornerRadius = 7,
		labelColor = { default={255} },
		fillColor = { default= { 25, 118, 210, 0.4 }, over= { 1, 87, 155, 0.1 } },
		---labelColor = { default={255}, over={128} },
		---default="button.png",
		---over="button-over.png",
		width=110, height=26,
		font=pixelFont,
		fontSize=22,
		onRelease = vibratingFunc
	}
	levelBtn = widget.newButton{
		label=hardTranslated[language],
		labelColor = { default={255, 255, 255, 1} },
		--default="button.png",
		--over="button-over.png",
		shape="roundedRect",
		cornerRadius = 7,
		fillColor = { default= { 25, 118, 210, 0.4 }, over= { 1, 87, 155, 0.1 } },
		width=110, height=30,
		font=pixelFont,
		fontSize=25,
		onRelease = changingDifficulty
	}
	-- LOADING SETTINGS
		if gameSettings[1] == true then 
			muteBtn:setLabel(unmuteTranslated[language])
			muted = true
			touchMute = 2
		else
			muted = false
			touchMute = 1
		end
		if gameSettings[2] == false then 
			vibrateBtn:setLabel(unvibrateTranslated[language])
			vibrating = false
			touchVibr = 2
		else
			vibrating = true
			touchVibr = 1
		end
		if gameSettings[3] == "hard" then
			levelBtn:setLabel(easyTranslated[language])
			level = "hard"
			touchLevel = 3
		elseif gameSettings[3] == "easy" then
		    levelBtn:setLabel(hardTranslated[language])
			level = "easy"
			touchLevel = 2
		elseif gameSettings[3] == "timed" then
			levelBtn:setLabel(timedTranslated[language])
			level = "timed"
			touchLevel = 4
		else
			levelBtn:setLabel(classicTranslated[language])
			level = "classic"
			touchLevel = 1
		end
		if gameSettings[4] == false then
			greenTutorial = false
		else
			greenTutorial = true
		end
		if gameSettings[5] == false then
			yellowTutorial = false
		else
			yellowTutorial = true
		end
		if gameSettings[6] == false then
			bombTutorial = false
		else
			bombTutorial = true
		end
		if gameSettings[7] == false then
			blackbombTutorial = false
		else
			blackbombTutorial = true
		end
		if gameSettings[8] == false then
			greenTutorialTimed = false
		else
			greenTutorialTimed = true
		end
		if gameSettings[9] == false then
			yellowTutorialTimed = false
		else
			yellowTutorialTimed = true
		end
		if gameSettings[10] == false then
			missedTutorial = false
		else
			missedTutorial = true
		end
		if gameSettings[11] == false then
			purpleTutorial = false
		else
			purpleTutorial = true
		end
		if gameSettings[12] == false then
			classicTutorial = false
		else
			classicTutorial = true
		end
	-- end of loading settings
	playBtn.x = display.contentWidth*0.5 - 57
	playBtn.y = display.contentHeight - 165
	levelBtn.x = display.contentWidth*0.5 + 57
	levelBtn.y = display.contentHeight - 165
	welcomeText.x = display.contentWidth*0.5
	welcomeText.y = display.contentHeight*0.5 - 40
	credBtn.x = display.contentWidth*0.5
	credBtn.y = display.contentHeight - 70
	muteBtn.x = display.contentWidth*0.5 - 57
	muteBtn.y = display.contentHeight - 100
	vibrateBtn.x = display.contentWidth*0.5 + 57
	vibrateBtn.y = display.contentHeight - 100
	touch = 1
end

game()
replayVerif()
timer.performWithDelay(1000, replayVerif, 0)