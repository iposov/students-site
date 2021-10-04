from testsystem import create_tests, test


def square(n):
    line = "x" * n + "\n"
    return line * n


def left_bottom_triangle(n):
    triangle = ""
    for i in range(1, n + 1):  # from 1 to n
        triangle += "x" * i + "\n"
    return triangle


def left_up_triangle(n):
    triangle = ""
    for i in range(n, 0, -1):  # from n downto 1
        triangle += "x" * i + "\n"
    return triangle


def right_bottom_triangle(n):
    triangle = ""
    for i in range(1, n + 1):  # from 1 to n
        triangle += ("x" * i).rjust(n, ' ') + "\n"
    return triangle


print(square(5))
print(left_bottom_triangle(5))
print(left_up_triangle(5))
print(right_bottom_triangle(5))


def chessboard(n):
    board = ""
    for i in range(n):
        for j in range(n):
            board += str((i + j + 1) % 2)
        board += "\n"
    return board


print(chessboard(5))


def chessboard_cells(n, k):
    board = ""
    for i in range(n):
        for row in range(k):
            for j in range(n):
                board += str((i + j + 1) % 2) * k
            board += "\n"
    return board


print(chessboard_cells(4, 3))


def table(m, n):
    def repeat(line, k):
        return line[0:1] + line[1:3] * (k - 1) + line[3:]

    table = ["┌─┬─┐",
             "│ │ │",
             "├─┼─┤",
             "│ │ │",
             "└─┴─┘"]

    lines = repeat([repeat(line, n) for line in table], m)
    return '\n'.join(lines) + "\n"


print(table(3, 4))
print(table(1, 1))

# _1_to_6 = [[x] for x in range(1, 6)]
# create_tests(square, _1_to_6)
# create_tests(left_bottom_triangle, _1_to_6)
# create_tests(left_up_triangle, _1_to_6)
# create_tests(right_bottom_triangle, _1_to_6)
# create_tests(chessboard, _1_to_6)
#
# _1_to_6_xy = [[x, y] for x in range(1, 6) for y in range(1, 6)]
# create_tests(chessboard_cells, _1_to_6_xy)
# create_tests(table, _1_to_6_xy)

test(chessboard, "tests/chessboard.json.gz")
