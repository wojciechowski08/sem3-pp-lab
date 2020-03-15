class Pracownik(val nazwisko: String, var zwolniony: Boolean = false) {

  private zwolniony: Boolean = false
  Pracownik.iloscPracownikow += 1


  override def toString: String = {
    nazwisko + " czy zwolniony: " + zwolniony
  }

  def zwolnij: Unit = {
    if (!zwolniony) {
      zwolniony = true
      Pracownik.iloscPracownikow -= 1
    }
  }

  def liczbaPracownikow: Int = {
    Pracownik.iloscPracownikow
  }

}

Object Pracownik{
  private var iloscPracownikow: Int =0

}

