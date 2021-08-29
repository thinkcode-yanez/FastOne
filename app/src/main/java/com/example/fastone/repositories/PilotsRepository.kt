package com.example.fastone.repositories

import com.bumptech.glide.Glide

class PilotsRepository {

    val ocon =
        "https://www.formula1.com/content/dam/fom-website/drivers/E/ESTOCO01_Esteban_Ocon/estoco01.png.transform/2col/image.png"
    val hamilton =
        "https://www.formula1.com/content/dam/fom-website/drivers/L/LEWHAM01_Lewis_Hamilton/lewham01.png.transform/2col/image.png"
    val sainz =
        "https://www.formula1.com/content/dam/fom-website/drivers/C/CARSAI01_Carlos_Sainz/carsai01.png.transform/2col/image.png"
    val max_verstappen =
        "https://www.formula1.com/content/dam/fom-website/drivers/M/MAXVER01_Max_Verstappen/maxver01.png.transform/2col/image.png"
    val alonso =
        "https://www.formula1.com/content/dam/fom-website/drivers/F/FERALO01_Fernando_Alonso/feralo01.png.transform/2col/image.png"
    val bottas =
        "https://www.formula1.com/content/dam/fom-website/drivers/V/VALBOT01_Valtteri_Bottas/valbot01.png.transform/2col/image.png"
    val gasly =
        "https://www.formula1.com/content/dam/fom-website/drivers/P/PIEGAS01_Pierre_Gasly/piegas01.png.transform/2col/image.png"
    val giovinazzi =
        "https://www.formula1.com/content/dam/fom-website/drivers/A/ANTGIO01_Antonio_Giovinazzi/antgio01.png.transform/2col/image.png"
    val latifi =
        "https://www.formula1.com/content/dam/fom-website/drivers/N/NICLAF01_Nicholas_Latifi/niclaf01.png.transform/2col/image.png"
    val leclerc =
        "https://www.formula1.com/content/dam/fom-website/drivers/C/CHALEC01_Charles_Leclerc/chalec01.png.transform/2col/image.png"
    val mazepin =
        "https://www.formula1.com/content/dam/fom-website/drivers/N/NIKMAZ01_Nikita_Mazepin/nikmaz01.png.transform/2col/image.png"
    val norris =
        "https://www.formula1.com/content/dam/fom-website/drivers/L/LANNOR01_Lando_Norris/lannor01.png.transform/2col/image.png"
    val perez =
        "https://www.formula1.com/content/dam/fom-website/drivers/S/SERPER01_Sergio_Perez/serper01.png.transform/2col/image.png"
    val raikkonen =
        "https://www.formula1.com/content/dam/fom-website/drivers/K/KIMRAI01_Kimi_R%C3%A4ikk%C3%B6nen/kimrai01.png.transform/2col/image.png"
    val ricciardo =
        "https://www.formula1.com/content/dam/fom-website/drivers/D/DANRIC01_Daniel_Ricciardo/danric01.png.transform/2col/image.png"
    val russell =
        "https://www.formula1.com/content/dam/fom-website/drivers/G/GEORUS01_George_Russell/georus01.png.transform/2col/image.png"
    val mick_schumacher =
        "https://www.formula1.com/content/dam/fom-website/drivers/M/MICSCH02_Mick_Schumacher/micsch02.png.transform/2col/image.png"
    val stroll =
        "https://www.formula1.com/content/dam/fom-website/drivers/L/LANSTR01_Lance_Stroll/lanstr01.png.transform/2col/image.png"
    val tsunoda =
        "https://www.formula1.com/content/dam/fom-website/drivers/Y/YUKTSU01_Yuki_Tsunoda/yuktsu01.png.transform/2col/image.png"
    val vettel =
        "https://www.formula1.com/content/dam/fom-website/drivers/S/SEBVET01_Sebastian_Vettel/sebvet01.png.transform/2col/image.png"


    fun getPilot(id: String): String =

        when (id) {
            "ocon" -> ocon
            "hamilton" -> hamilton
            "sainz" -> sainz
            "max_verstappen"->max_verstappen
            "alonso"->alonso
            "bottas"->bottas
            "gasly"->gasly
            "giovinazzi"->giovinazzi
            "latifi"->latifi
            "leclerc"->leclerc
            "maxepin"->mazepin
            "norris"->norris
            "perez"->perez
            "raikkonen"->raikkonen
            "ricciardo"->ricciardo
            "russel"->russell
            "mick_schumacher"->mick_schumacher
            "stroll"->stroll
            "tsunoda"->tsunoda
            "vettel"->vettel

            else -> "null"

        }


}



