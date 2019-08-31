package swexpert;

public class TableCalculator2 {

}

//#define MAXR 99
//#define MAXC 26
//
//#define NUM (0)
//#define ADD (1)
//#define SUB (2)
//#define MUL (3)
//#define DIV (4)
//#define MAX (5)
//#define MIN (6)
//#define SUM (7)
//
//#define MINUS_INF (-1000000005)
//#define PLUS_INF (1000000005)
//
//#define _MIN(a, b) ((a) < (b) ? (a) : (b))
//#define _MAX(a, b) ((a) > (b) ? (a) : (b))
//#define _ABS(a) ((a) < 0 ? -(a) : (a))
//
//int mx_r;
//int mx_c;
//
//struct Pos
//{
//	int r;
//	int c;
//};
//
//struct Cell
//{
//	Pos left;
//	Pos right;
//	int type;
//	int val;
//};
//
//Cell Cells[MAXR + 5][MAXC + 5];
//
//int visit[MAXR + 5][MAXC + 5];
//int visit_cnt;
//
//void init(int C, int R)
//{
//	mx_r = R;
//	mx_c = C;
//	visit_cnt = 0;
//
//	for (register int i = 1; i <= mx_r; ++i)
//	{
//		for (register int j = 1; j <= mx_c; ++j)
//		{
//			Cell* current_cell = &Cells[i][j];
//			current_cell->type = NUM;
//			current_cell->val = 0;
//			visit[i][j] = 0;
//		}
//	}
//}
//
//int num_parse(const char* str, register int& cur)
//{
//	register int ret = 0;
//
//	for (; str[cur] >= '0' && str[cur] <= '9'; ++cur) ret = ret * 10 + str[cur] - '0';
//	return ret;
//}
//
//void parse(const char* str, Cell* current_cell, int type)
//{
//	int cur = 5;
//
//	current_cell->type = type;
//
//	current_cell->left.c = str[4] - 'A' + 1;
//	current_cell->left.r = num_parse(str, cur);
//
//	current_cell->right.c = str[++cur] - 'A' + 1;
//	current_cell->right.r = num_parse(str, ++cur);
//}
//
//void set(int col, int row, char input[])
//{
//	int cur;
//	Cell* current_cell = &Cells[row][col];
//
//	if (input[0] == '-')
//	{
//		cur = 1;
//		current_cell->type = NUM;
//		current_cell->val = -num_parse(input, cur);
//	}
//	else if (input[0] >= '0' && input[0] <= '9')
//	{
//		cur = 0;
//		current_cell->type = NUM;
//		current_cell->val = num_parse(input, cur);
//	}
//	else
//	{
//		char &id = input[2];
//
//		if (id == 'D') parse(input, current_cell, ADD);
//		else if (id == 'B') parse(input, current_cell, SUB);
//		else if (id == 'L') parse(input, current_cell, MUL);
//		else if (id == 'V') parse(input, current_cell, DIV);
//		else if (id == 'X') parse(input, current_cell, MAX);
//		else if (id == 'N') parse(input, current_cell, MIN);
//		else if (id == 'M') parse(input, current_cell, SUM);
//	}
//}
//
//int calc(int col, int row)
//{
//	Cell* current_cell = &Cells[row][col];
//
//	int& type = current_cell->type;
//	int& val = current_cell->val;
//	Pos& left = current_cell->left;
//	Pos& right = current_cell->right;
//
//	if (visit[row][col] == visit_cnt || type == NUM) return val;
//
//	visit[row][col] = visit_cnt;
//
//	int left_val = calc(left.c, left.r);
//	int right_val = calc(right.c, right.r);
//
//	if (type == ADD) val = left_val + right_val;
//	else if (type == SUB) val = left_val - right_val;
//	else if (type == MUL) val = left_val * right_val;
//	else if (type == DIV) val = left_val / right_val;
//	else if (type == MAX)
//	{
//		val = MINUS_INF;
//		for (register int i = left.r; i <= right.r; ++i)
//		{
//			for (register int j = left.c; j <= right.c; ++j)
//			{
//				int res = calc(j, i);
//				val = _MAX(val, res);
//			}
//		}
//	}
//	else if (type == MIN)
//	{
//		val = PLUS_INF;
//		for (register int i = left.r; i <= right.r; ++i)
//		{
//			for (register int j = left.c; j <= right.c; ++j)
//			{
//				int res = calc(j, i);
//				val = _MIN(val, res);
//			}
//		}
//	}
//	else
//	{
//		val = 0;
//		for (register int i = left.r; i <= right.r; ++i)
//		{
//			for (register int j = left.c; j <= right.c; ++j)
//			{
//				int res = calc(j, i);
//				val += res;
//			}
//		}
//	}
//
//	return val;
//}
//
//void update(int value[MAXR][MAXC])
//{
//	++visit_cnt;
//
//	for (register int i = 1; i <= mx_r; ++i)
//	{
//		for (register int j = 1; j <= mx_c; ++j)
//		{
//			value[i - 1][j - 1] = calc(j, i);
//		}
//	}
//}