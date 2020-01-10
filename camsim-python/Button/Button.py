class Button:
    name: str
    state: int  # 0 not; 1 pressed

    def __init__(self, name: str) -> object:
        name = self.name
        state = 0

    def __str__(self):
        return self.name

    def getname(self):
        return self.name

    def getstate(self):
        return self.state

    def reset(self):
        self.state = 0

    def press(self):
        self.state = 1

    def hold(self):
        self.state = 1
        # IMPLEMENT STILL PRESSED STATE

    def unpress(self):
        self.reset()
