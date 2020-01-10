from Battery.Battery import Battery
from Body.Sensor import Sensor
from Body.Shutter import Shutter
from Display.Display import Display
from Lens.Aperture import Aperture
from Lens.Lens import Lens
from MemoryCard.Card import Card

oBattery = Battery()
oCard = Card(64, 90, 170)
oLens = Lens(50, 1.8, 32.0)

oSensor = Sensor(102400, 100)
oShutter = Shutter(1/1000)
oAperture = Aperture()

oDisplay = Display() # LCD EVF here for further development
#buttons






