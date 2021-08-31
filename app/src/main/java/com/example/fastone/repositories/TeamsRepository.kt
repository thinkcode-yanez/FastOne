package com.example.fastone.repositories

class TeamsRepository {

    val mercedes="https://www.formula1.com/content/dam/fom-website/teams/2021/mercedes-logo.png.transform/2col/image.png"
    val red_bull="https://www.formula1.com/content/dam/fom-website/teams/2021/red-bull-racing-logo.png.transform/2col/image.png"
    val mclaren="https://www.formula1.com/content/dam/fom-website/teams/2021/mclaren-logo.png.transform/2col/image.png"
    val ferrari="https://www.formula1.com/content/dam/fom-website/teams/2021/ferrari-logo.png.transform/2col/image.png"
    val alpine="https://www.formula1.com/content/dam/fom-website/teams/2021/alpine-logo.png.transform/2col/image.png"
    val alphatauri="https://www.formula1.com/content/dam/fom-website/teams/2021/alphatauri-logo.png.transform/2col/image.png"
    val aston_martin="https://www.formula1.com/content/dam/fom-website/teams/2021/aston-martin-logo.png.transform/2col/image.png"
    val williams="https://www.formula1.com/content/dam/fom-website/teams/2021/williams-logo.png.transform/2col/image.png"
    val alpha="https://www.formula1.com/content/dam/fom-website/teams/2021/alfa-romeo-racing-logo.png.transform/2col/image.png"
    val hass="https://www.formula1.com/content/dam/fom-website/teams/2021/haas-f1-team-logo.png.transform/2col/image.png"


    fun getTeamLogo(id: String): String =

        when(id){
            "mercedes"->mercedes
            "red_bull"->red_bull
            "mclaren"->mclaren
            "ferrari"->ferrari
            "alpine"->alpine
            "alphatauri"->alphatauri
            "aston_martin"->aston_martin
            "williams"->williams
            "alfa"->alpha
            "haas"->hass
            else->hass//Cambiar a null

        }
}