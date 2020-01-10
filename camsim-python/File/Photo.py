import random
import string

from File.File import File


class Photo(File):
    exposureLevel: float  # 0 = good, - = under, + = over

    def __init__(self, name, ext, size, time):
        super().__init__(name, ext, size, time)
        # super().data = ''.join(random.choices(string.ascii_uppercase + string.digits, k=10))

    def setData(self, data: str):
        self.data = data

    def setExposureLevel(self, ev: float):
        self.exposureLevel = ev

    def getExposureLevel(self) -> float:
        return self.exposureLevel
