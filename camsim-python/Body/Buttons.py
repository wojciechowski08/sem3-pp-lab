from typing import List, Union

from Button.ArrowButton import ArrowButton
from Button.Button import Button
from Button.Dial import Dial
from Button.ShutterButton import ShutterButton
from Button.Switch import Switch


sPOWER = Switch("POWER")

bISO = Button("ISO")
bMENU = Button("Menu")
bINFO = Button("Info")
# bLOCK = Button("LOCK")

bGALLERY = Button("Gallery")
# bUP = ArrowButton("UP")
# bDOWN = ArrowButton("DOWN")
bLEFT = ArrowButton("LEFT")
bRIGHT = ArrowButton("RIGHT")

bSHUTTER = ShutterButton('SHUTTER')

dFRONT = Dial("FRONT DIAL")
dBACK = Dial("BACK DIAL")

# buttons: List[Button] = [bISO, bMENU, bINFO, bLOCK, bGALLERY,
#                          bUP, bDOWN, bLEFT, bRIGHT]
buttons: List[Button] = [bISO, bMENU, bINFO, bGALLERY,
                         bLEFT, bRIGHT]
dials: List[Dial] = [dFRONT, dBACK]
switches: List[Switch] = [sPOWER]


# class Buttons:
#
#     # class ArrowButtons(Buttons):
#     #     pass
#
#     def __init__(self):
#         sPOWER = Switch("POWER")
#
#         bISO = Button("ISO")
#         bMENU = Button("Menu")
#         bINFO = Button("Info")
#         bLOCK = Button("LOCK")
#
#         bGALLERY = Button("Gallery")
#         bUP = ArrowButton("UP")
#         bDOWN = ArrowButton("DOWN")
#         bLEFT = ArrowButton("LEFT")
#         bRIGHT = ArrowButton("RIGHT")
#         dFRONT = Dial("FRONT DIAL")
#         dBACK = Dial("BACK DIAL")


