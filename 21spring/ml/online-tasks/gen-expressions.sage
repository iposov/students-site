f = propcalc.formula("a&((b|c)^a->c)<->b")
g = propcalc.formula("a|a")

from random import choice, sample
import sage.logic.logicparser as logicparser

operations = ['|', '&', '^', '->', '<->','^']
def create_formula(ops, variables):
    if ops == 0:
        v = sample(variables, 1)
        result = v
        var_set = set(v)
    else:
        left_ops = choice(range(ops))
        right_ops = ops - 1 - left_ops
        f1, s1 = create_formula(left_ops, variables)
        f2, s2 = create_formula(right_ops, variables)
        result = [choice(operations), f1, f2]
        var_set = s1 | s2

    if choice(range(5)) == 0:
        result = ['~', result]

    return result, var_set

@interact
def _(
        variables=selector([1, 2, 3], label="Количество переменных", buttons=True),
        size=selector([2, 3, 4, 5, 6], label="Количество операций", buttons=True),
        auto_update=False
    ):
        all_vars = ['a', 'b', 'c'][:variables]
        while True:
            f_list, var_set = create_formula(size, all_vars)
            if len(var_set) == variables:
                break

        f_string = logicparser.recover_formula(f_list)
        f = propcalc.formula(f_string)
        show(f)
        tt = f.truthtable()
        table_header, *table_rows = tt.get_table_list()
        # inds = {v: table_header.index(v) for v in all_vars}
        inds = {all_vars[i]: i for i in range(len(all_vars))}
        # print(' '.join(all_vars + ['f']))
        print(' '.join(table_header + ['f']))
        for table_row in table_rows:
            str_row = ['1' if table_row[inds[v]] else '0' for v in all_vars]
            str_row.append('1' if table_row[variables] else '0')
            print(' '.join(str_row))


