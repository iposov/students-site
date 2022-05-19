class Time:

    def __init__(self, h, m):
        self.h = h
        self.m = m

    def show(self):
        # h_text = str(self.h)
        # if self.h < 10:
        #     h_text = '0' + h_text
        #
        # m_text = str(self.m)
        # if self.m < 10:
        #     m_text = '0' + m_text
        #
        # return f'{h_text}:{m_text}'
        return f'{self.h:02d}:{self.m:02d}'

    def __str__(self):
        return self.show()

    def is_morning(self):
        return 5 <= self.h <= 8

    def is_day(self):
        return 9 <= self.h <= 18

    def is_evening(self):
        return 19 <= self.h <= 22

    def is_night(self):
        return self.h >= 23 or self.h < 5

    def say_hello(self):
        if self.is_morning():
            print("Good morning")
        elif self.is_day():
            print("Good day")
        elif self.is_evening():
            print("Good evening")
        else:  # is night
            print("Good night")

    def add_minutes(self, m):
        self.m += m              # 59 + 62 = 121
        extra_hours = self.m // 60
        self.m %= 60  # self.m = self.m % 60
        self.h += extra_hours
        self.h %= 24


t = Time(12, 23)
t2 = Time(8, 5)
print(t.show())
print(t2.show())

t.say_hello()
t2.say_hello()
t.add_minutes(120)
print(t.show())

print(str(t))
print(t)
