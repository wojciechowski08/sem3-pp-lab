from Battery.Battery import Battery
from Body.Body import Body
from Body.Sensor import Sensor
from Body.Shutter import Shutter
from Display.Display import Display
from Lens.Lens import Lens
from Lens.Aperture import Aperture
from MemoryCard.Card import Card

oBody = Body()
oBattery = Battery()
oCard = Card(64, 90, 170)
oLens = Lens(50, 2.0, 32.0)

oSensor = Sensor(102400, 100)
oShutter = Shutter(1/1000)
oAperture = Aperture(oLens)

oDisplay = Display() # LCD EVF here for further development
#buttons






