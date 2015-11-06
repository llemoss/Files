-----------------------------------------------------------------------------------------
--
-- main.lua
--
-----------------------------------------------------------------------------------------
pixelFont = "alterebro-pixel-font.ttf"
local physics = require("physics")
local widget = require ("widget")
local gameNetwork = require("gameNetwork")
system.activate("multitouch")
gameNetwork.init("google")

language = system.getPreference( "ui", "language" )
------------
local leaderboardId  = "CgkIuNfVtdgXEAIQBg" -- Max Score
local achievementId1 = "CgkIuNfVtdgXEAIQAQ" -- Boom!
local achievementId2 = "CgkIuNfVtdgXEAIQAg" -- Bonus, bonus, bonus!
local achievementId3 = "CgkIuNfVtdgXEAIQAw" -- Awful luck!
local achievementId4 = "CgkIuNfVtdgXEAIQBA" -- Balloon Master!
local achievementId5 = "CgkIuNfVtdgXEAIQBQ" -- Balloon Expert!

halfW = display.contentWidth*0.5
halfH = display.contentHeight*0.5
bkg = display.newImage("night_sky.png", halfW, halfH)

local musicStream = audio.loadStream("music.mp3")
local bombPop = audio.loadSound("bomb.wav")
local balloonPop = audio.loadSound("balloon.mp3") --Credits to https://goo.gl/noA3Qk
local bonusPop = audio.loadSound("bonus.mp3")
audio.setMaxVolume(0.1, {channel=0} )
audio.setMaxVolume(0.5, {channel=1} )
--------------------------------------------------------------Misc var
local scoreText
local missedText
alreadyReplayed = 0
quantBalloons = 1
delayBonus = 200
multQuant = 25
objectsCreated = 0
score = 0
initGravity = 4
balloonsMissed = 0
gameoverbyblackbomb = 0
blueballoonPopped = 0
balloonsPopped = 0
purpleballoonPopped = 0
maxScore = score
timereplay = {}
bannerID = "ca-app-pub-8381955435061603/2874149443"
unusedWidth		= display.actualContentWidth - display.contentWidth
unusedHeight		= display.actualContentHeight - display.contentHeight
left				= 0 - unusedWidth/2
top 				= 0 - unusedHeight/2
right 			= display.contentWidth + unusedWidth/2
bottom 			= display.contentHeight + unusedHeight/2
size 				= display.viewableContentHeight/15
buttonTextSize 	= display.viewableContentWidth/20
width = display.viewableContentWidth - display.viewableContentWidth/100
--------------------------------------------------------------end of misc variables
----- TRANSLATIONS -----
boardsTranslated = {
["English"] = "Leaderboards!",
["português"] = "Placares!"}
gameoverTranslated = {
	["English"] = "Aw.. You can try again!\nMissed: %d\nMax score: %d",
	["português"] = "Ah.. Tente novamente!\nErrados: %d\nMaior placar: %d",
}
missedTranslated = {
	["English"] = "Missed:",
	["português"] = "Errados:",
}
scoreTranslated = {
	["English"] = "Score:",
	["português"] = "Placar:",
}
welcome2Translated = {
	["English"] = "Red/orange ones = +1 point\nBlue ones = 2x score\nPurple ones = 0 missed\nRed bombs = half score!\nBlack bombs or missing 10 balloons\nwill end the game!\n",
	["português"] = "Vermelhos/laranjas = +1 ponto\nAzuis = 2x o placar\nRoxos = 0 errados\nBombas vermelhas = metade do placar!\nBombas pretas ou errar dez acabam o jogo!\n",
}
welcome1Translated = {
	["English"] = "Welcome to Balloon's Sky!\nTry your best to make the best score!",
	["português"] = "Chuva de Balões!\nTente o seu melhor\npara obter o melhor placar!",
}
playTranslated = {
	["English"] = "Play!",
	["português"] = "Jogar!",
}
creditsTranslated = {
	["English"] = "Producer and composer\nGildásio Filho - gildasiogx@gmail.com\n\nArtwork\nJulia Gudino - juliahbgudino@gmail.com\n\nAttribution to balloon's \npop sound:\nhttps://goo.gl/noA3Qk\n\nBalloon's Sky is licensed\nunder the Creative Commons\nattribution, non commercial\nand no derivatives 4.0 international\nlicense. To view a copy of this\nlicense, see:\nhttp://goo.gl/TMTQGk\n",
	["português"] = "Produtor e compositor\nGildásio Filho - gildasiogx@gmail.com\n\nArtwork\nJulia Gudino - juliahbgudino@gmail.com\n\nAtribuição ao som do balão:\nhttps://goo.gl/noA3Qk\n\nBalloon's Sky é licenciado sobre a\nCreative Commons internacional 4.0\nde atribuição, não comercial e\nsem derivados. Para ver uma cópia\nda licença, veja:\nhttp://goo.gl/TMTQGk\n",}
submitTranslated = {
	["English"] = "Submit score!",
	["português"] = "Submeter placar!",}
credBtnTranslated = {
	["English"] = "Credits",
	["português"] = "Créditos",}

----- END OF TRANSLATIONS -----

if language ~= "português" then
	language = "português"
end

--------------------------------------------------------------begin of Google Play stuff

local function showLeaderboards()
		gameNetwork.show("leaderboards")
		print("Trying to show leaderboards")
end

local function submitScoreListener(event)
	gameNetwork.request("setHighScore", 
		{
			localPlayerScore = 
			{
				category = "CgkIuNfVtdgXEAIQBg", -- Id of the leaderboard to submit the score into
				value = maxScore -- The score to submit
			}
		})
	scoreSubmitButton:removeSelf()
	scoreSubmitButton = widget.newButton
	{
		width=120, height=40,
		label = boardsTranslated[language],
		labelColor = { default={255}, over={128} },
		fontSize = buttonTextSize,
		font=pixelFont,
		fontSize=24,
		onRelease = showLeaderboards,
	}
	scoreSubmitButton.x = display.contentWidth*0.5
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


local ads=require("ads")

local function adListener( event )
   for k,v in pairs( event ) do
      print("adListener ", k, v ) -- so you see everything you get
   end
end

ads.init("admob", bannerID, adListener )
ads:setCurrentProvider("admob")
ads.load("admob", { appId = bannerID, testMode = false })

local function showAd( adPosition, isTestMode )
   local xPos, yPos
   if adPosition == "top" then
      xPos, yPos = display.screenOriginX, top
   elseif adPosition == "bottom" then
      xPos, yPos = display.screenOriginX, bottom
   end
   ads:setCurrentProvider("admob")
   ads.show( "banner", { x = xPos, y = yPos, appId = bannerID, testMode = isTestMode } )
end

showAd( "bottom", false )

--------------------------------------------------------------end of Google Play stuff
local function balloonTouched(event)
	if(event.phase == "began") then
		Runtime:removeEventListener("enterFrame", event.self)
		event.target:removeSelf()
		balloonStream = audio.play(balloonPop)
		system.vibrate()
		balloonsPopped = balloonsPopped + 1
		older = score
		olderMax = maxScore
		score = score + 1
		if score > older then
			maxScore = score
		end
		if maxScore < olderMax then
			maxScore = olderMax
		end
		scoreText.text = string.format(scoreTranslated[language] .. " %d", score)
	end
end

local function bombTouched(event)
	if(event.phase == "began") then
		Runtime:removeEventListener("enterFrame", event.self)
		event.target:removeSelf()
		system.vibrate()
		bombStream = audio.play(bombPop)
		older = score
		olderMax = maxScore
		score = math.floor(score*0.5)
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
	system.vibrate()
	end
	if (score > 0) then
		timer.cancel(timereplay[0])
		timer.cancel(timerverif)
		bkg = display.newImage("night_sky.png", halfW, halfH)
		scoreText:removeSelf()
		missedText:removeSelf()
		overText = display.newText(string.format(gameoverTranslated[language], balloonsMissed, maxScore), halfW, halfH, pixelFont, 25)
		physics.stop()
		gameover = true
		gameoverbyblackbomb = 1
		system.vibrate()
		print("gameover = true")
		audio.fade( { channel=1, time=4000, volume=0.0 } )
	else
		scoreText.text = string.format(scoreTranslated[language] .. " %d", score)
	end
end

local function blueballoonTouched(event)
	if(event.phase == "began") then
		Runtime:removeEventListener("enterFrame", event.self)
		event.target:removeSelf()
		bonusStream = audio.play(bonusPop)
		system.vibrate()
		blueballoonPopped = blueballoonPopped + 1
		balloonsPopped = balloonsPopped + 1
		older = score
		olderMax = maxScore
		score = score*2
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
		system.vibrate()
		balloonsPopped = balloonsPopped + 1
		if balloonsMissed == 0 then
		purpleballoonPopped = 0
		end
		if balloonsMissed > 0 then
		purpleballoonPopped = purpleballoonPopped + 10
		end
		balloonsMissed = 0
		scoreText.text = string.format(scoreTranslated[language] .. " %d", score)
		missedText.text = string.format(missedTranslated[language] .. " %d", balloonsMissed)
	end
end

local function offscreenBalloon(self, event)
	if (self.y == nil) then
		return
	end
	if (self.y > display.contentHeight*2) then
		Runtime:removeEventListener("enterFrame", self)
		self:removeSelf()
		if score > 0 then
			balloonsMissed = balloonsMissed + 1
			missedText.text = string.format(missedTranslated[language] .. " %d", balloonsMissed)
		end
	end
end

local function offscreen(self, event)
	if (self.y == nil) then
		return
	end
	if (self.y > display.contentHeight*2) then
		Runtime:removeEventListener("enterFrame", self)
		self:removeSelf()
	end
end

local function addNewBallonOrBomb()
	if (math.random(1, 6) == 1) then
		local startX = math.random(display.contentWidth*0.1, display.contentWidth*0.9)
		local startY = math.random(-600, -300)
		local bomb = display.newImage("bombzero.png", startX, startY)
		physics.addBody(bomb, {radius = 50, friction = 0, bounce = 0, isSensor=true})
		bomb.enterFrame = offscreen
		Runtime:addEventListener("enterFrame", bomb)
		bomb:addEventListener("touch", bombTouched)
		objectsCreated = objectsCreated + 1
	elseif (math.random(1, 150) == 1) then
		local startX = math.random(display.contentWidth*0.1, display.contentWidth*0.9)
		-- bomba do mal
		local bombzero = display.newImage("bomb.png", startX, -500)
		physics.addBody(bombzero, {radius = 50, friction = 0, bounce = 0, isSensor=true})
		bombzero.enterFrame = offscreen
		Runtime:addEventListener("enterFrame", bombzero)
		bombzero:addEventListener("touch", bombzeroTouched)
		objectsCreated = objectsCreated + 1
	elseif (math.random(1, 80) == 1) then
		local startX = math.random(display.contentWidth*0.1, display.contentWidth*0.9)
		local blueballoon = display.newImage("blue_balloon.png", startX, -700)
		physics.addBody(blueballoon, {radius = 80, friction = 0, bounce = 0, isSensor=true})
		blueballoon.enterFrame = offscreenBalloon
		Runtime:addEventListener("enterFrame", blueballoon)
		blueballoon:addEventListener("touch", blueballoonTouched)
		objectsCreated = objectsCreated + 1
	elseif (math.random(1, 90) == 1) then
		local startX = math.random(display.contentWidth*0.1, display.contentWidth*0.9)
		local purpleballoon = display.newImage("purple_balloon.png", startX, -300)
		physics.addBody(purpleballoon, {radius = 80, friction = 0, bounce = 0, isSensor=true})
		purpleballoon.enterFrame = offscreen
		Runtime:addEventListener("enterFrame", purpleballoon)
		purpleballoon:addEventListener("touch", purpleballoonTouched)
		objectsCreated = objectsCreated + 1
	elseif (math.random(1, 6) ~= 1) then
		local startX = math.random(display.contentWidth*0.1, display.contentWidth*0.9)
		local startY = math.random(-600, -300)
		balloon = display.newImage("red_balloon_2.png", startX, startY)
		physics.addBody(balloon, {radius = 80, friction = 0, bounce = 0, isSensor=true})
		balloon.enterFrame = offscreenBalloon
		Runtime:addEventListener("enterFrame", balloon)
		balloon:addEventListener("touch", balloonTouched)
		objectsCreated = objectsCreated + 1
	else
		local startX = math.random(display.contentWidth*0.1, display.contentWidth*0.9)
		local startY = math.random(-600, -300)
		balloon = display.newImage("red_balloon.png", startX, startY)
		physics.addBody(balloon, {radius = 80, friction = 0, bounce = 0, isSensor=true})
		balloon.enterFrame = offscreenBalloon
		Runtime:addEventListener("enterFrame", balloon)
		balloon:addEventListener("touch", balloonTouched)
		objectsCreated = objectsCreated + 1
	end
end

local function verif()
	print("Funcao verif em andamento..")
	print("Objetos criados:", objectsCreated)
	if (objectsCreated%10) == 0 then
		physics.setGravity(0, initGravity + 0.5)
		print("Gravidade aumentada em 0.5")
	elseif (objectsCreated%multQuant == 0 and quantBalloons < 4) then
		timereplay[quantBalloons] = timer.performWithDelay(delay, addNewBallonOrBomb, 0)
		delay = delay + delayBonus + 100
		quantBalloons = quantBalloons + 1
		multQuant = math.floor(multQuant*2.5) + quantBalloons
		print("Quantidade de baloes atual:", quantBalloons)
		print("Delay extra:", delay)
		print("Multiplier:", multQuant)
	elseif (balloonsMissed >= 10 and gameover == false) then
		timer.cancel(timereplay[0])
		timer.cancel(timerverif)
		bkg = display.newImage("night_sky.png", halfW, halfH)
		scoreText:removeSelf()
		missedText:removeSelf()
		overText = display.newText(string.format(gameoverTranslated[language], balloonsMissed, maxScore), halfW, halfH, pixelFont, 25)
		physics.stop()
		gameover = true
		print("gameover = true")
		audio.fade( { channel=1, time=4000, volume=0.0 } )
	end
end

local function game()
		gameover = false
		print("gameover = false")
		replayConfirm = false
		print("replayConfirm =  false")
		music = audio.play(musicStream, {channel = 1, loops = -1})
		delay = 1000
		scoreText = display.newText(string.format(scoreTranslated[language] .. " %d", score), halfW-100, 10, pixelFont, 30)
		missedText = display.newText(string.format(missedTranslated[language] .. " %d", balloonsMissed), halfW+90, 10, pixelFont, 30)
		physics.start()
		physics.setGravity(0, initGravity)
		if (gameover == false) then
			addNewBallonOrBomb()
			verif()
			timereplay[0] = timer.performWithDelay(delay + 200, addNewBallonOrBomb, 0)
			timerverif = timer.performWithDelay(delay, verif, 0)
			print("Timers acionados")
		else
			physics.pause()
		end
		
	end

local function playGame()
	if touch == 1 then
		playBtn:removeSelf()
		credBtn:removeSelf()
		welcomeText:removeSelf()
		loginLogout()
		welcomeText = widget.newButton{
		label=welcome2Translated[language],
		labelColor = { default={255}, over={128} },
		default="button.png",
		over="button-over.png",
		font=pixelFont,
		fontSize=25,
		textOnly=true
	}
		okBtn = widget.newButton{
		label="Ok!",
		labelColor = { default={255}, over={128} },
		default="button.png",
		over="button-over.png",
		font=pixelFont,
		fontSize=25,
		width=100, height=40,
		onRelease = playGame
	}
	okBtn.x = display.contentWidth*0.5
	okBtn.y = display.contentHeight - 100
	welcomeText.x = display.contentWidth*0.5
	welcomeText.y = display.contentHeight*0.5
	touch = 2
	elseif touch == 2 then
		okBtn:removeSelf()
		welcomeText:removeSelf()
		game()	
	end
end

local function replayGame()
		objectsCreated = 0
		score = 0
		initGravity = 5
		multQuant = 25
		delayBonus = 200
		balloonsMissed = 0
		gameoverbyblackbomb = 0
		blueballoonPopped = 0
		balloonsPopped = 0
		purpleballoonPopped = 0
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
		scoreSubmitButton:removeSelf()
		game()
		audio.rewind( { channel=1 } )
		audio.fade( { channel=1, time=1500, volume=0.5 } )
end

local function credits()
	welcomeText:removeSelf()
	credBtn:removeSelf()
	loginLogout()
	playBtn.x = display.contentWidth*0.5
	playBtn.y = display.contentHeight - 70
	credBtn = widget.newButton{
		label=creditsTranslated[language],
		labelColor = { default={255}, over={128} },
		default="button.png",
		over="button-over.png",
		font=pixelFont,
		fontSize=25,
		textOnly=true
	}
	credBtn.x = display.contentWidth*0.5
	credBtn.y = display.contentHeight*0.5
end

local function gameoverVerif()
	print("Verificando se gameover & replayConfirm = true...")
	if (gameover == true and replayConfirm == true) then
		print("Criando botao de replay")
		reBtn = widget.newButton{
		label="Replay?",
		labelColor = { default={255}, over={128} },
		default="button.png",
		over="button-over.png",
		width=110, height=40,
		font=pixelFont,
		fontSize=25,
		onRelease = replayGame
	}
	reBtn.x = display.contentWidth*0.5
	reBtn.y = display.contentHeight - 125
	scoreSubmitButton = widget.newButton
	{
		width=120, height=40,
		label = submitTranslated[language],
		labelColor = { default={255}, over={128} },
		fontSize = buttonTextSize,
		font=pixelFont,
		fontSize=23,
		onRelease = submitScoreListener,
	}
	scoreSubmitButton.x = display.contentWidth*0.5
	scoreSubmitButton.y = display.contentHeight - 85
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

local function achievementVerif()
	if gameoverbyblackbomb == 1 then
	unlockAchievement(achievementId1)
	end
	if blueballoonPopped == 5 then
		unlockAchievement(achievementId2)
	end
	if balloonsMissed == 9 and gameoverbyblackbomb == 1 then
		unlockAchievement(achievementId3)
	end
	if balloonsPopped == 500 then
		unlockAchievement(achievementId4)
	end
	if balloonsPopped == 100 then
		unlockAchievement(achievementId5)
	end
end

local function initGame()
	native.getFontNames()
	welcomeText = widget.newButton{
		label=welcome1Translated[language],
		labelColor = { default={255}, over={128} },
		default="button.png",
		over="button-over.png",
		fontSize=30,
		font=pixelFont,
		textOnly=true
	}
	playBtn = widget.newButton{
		label=playTranslated[language],
		labelColor = { default={255}, over={128} },
		default="button.png",
		over="button-over.png",
		width=110, height=40,
		font=pixelFont,
		fontSize=25,
		onRelease = playGame
	}
	credBtn = widget.newButton{
		label=credBtnTranslated[language],
		labelColor = { default={255}, over={128} },
		default="button.png",
		over="button-over.png",
		width=110, height=40,
		font=pixelFont,
		fontSize=25,
		onRelease = credits
	}
	playBtn.x = display.contentWidth*0.5
	playBtn.y = display.contentHeight - 160
	welcomeText.x = display.contentWidth*0.5
	welcomeText.y = display.contentHeight*0.5
	credBtn.x = display.contentWidth*0.5
	credBtn.y = display.contentHeight - 120
	touch = 1
end

initGame()
replayVerif()
timer.performWithDelay(1000, replayVerif, 0)
achievementVerif()
timer.performWithDelay(500, achievementVerif, 0)