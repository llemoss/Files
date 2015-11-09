local aspectRatio = display.pixelHeight / display.pixelWidth

application =
{

	content =
	{
		width = aspectRatio > 1.5 and 320 or math.floor( 480 / aspectRatio ),
		height = aspectRatio < 1.5 and 480 or math.floor( 320 * aspectRatio ),
		scale = "letterBox",
		fps = 60,
		
		imageSuffix = {
			["@2x"] = 1.5,
			["@4x"] = 3.0,
						},
	},

	--[[
	-- Push notifications
	notification =
	{
		iphone =
		{
			types =
			{
				"badge", "sound", "alert", "newsstand"
			}
		}
	},
	--]]    
}