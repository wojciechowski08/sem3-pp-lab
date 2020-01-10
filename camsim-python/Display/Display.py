class Display:
    brightness:int
    state:int # 0 OFF 1 ON

    def __init__(self):
        self.brightness = 50
        self.state = 0