package com.finnvonholten.fitnesstagebuch

data class Uebung(val muskelgruppe: String,
                  val muskelgruppeDetail: String,
                  private val hauptMuskel1: String,
                  private val hauptMuskel2: String,
                  private val hauptMuskel3: String,
                  private val hauptMuskel4: String,
                  private val hauptMuskel5: String,
                  private val nebenMuskel1: String,
                  private val nebenMuskel2: String,
                  private val nebenMuskel3: String,
                  private val nebenMuskel4: String,
                  private val nebenMuskel5: String,
                  private val nebenMuskel6: String,
                  private val nebenMuskel7: String,
                  val uebung: String,
                  val schwierigkeit: String,
                  private val geraet1: String,
                  private val geraet2: String,
                  val bild: String) {


    fun nebenMuskelList(): List<String> {
        return listOfNotNull(nebenMuskel1, nebenMuskel2, nebenMuskel3, nebenMuskel4, nebenMuskel5, nebenMuskel6, nebenMuskel7)
    }

    fun hauptMuskelList(): List<String> {
        return listOfNotNull(hauptMuskel1, hauptMuskel2, hauptMuskel3, hauptMuskel4, hauptMuskel5)
    }

    fun geraeteList(): List<String> {
        return listOfNotNull(geraet1, geraet2)
    }
}
