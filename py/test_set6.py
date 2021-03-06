import unittest
import set6


class SortKTests(unittest.TestCase):
    def test_one(self):
        self.assertEqual([1,2,3,4], set6.sort_k_lists([[1, 2], [3, 4]]))
    def test_two(self):
        self.assertEqual([1,1,2,3,4,4,5,6], set6.sort_k_lists([[1, 4, 5], [1, 3, 4], [2, 6]]))

class SearchRotated(unittest.TestCase):
    def test_one(self):
        self.assertTrue(set6.search_rotated_sorted(2,[2,0,1]))
        self.assertTrue(set6.search_rotated_sorted(1,[2,0,1]))

        self.assertFalse(set6.search_rotated_sorted(1, [5,6,7,8,0,2,3]))
        self.assertTrue(set6.search_rotated_sorted(2, [2,3,5,6,7,8,0]))


class MaxSubArrayTest(unittest.TestCase):
    def test_simple(self):
        self.assertEqual(6, set6.max_subarray([-2,1,-3,4,-1,2,1,-5,4]))

class MinWindow(unittest.TestCase):
    def test_simple(self):
        self.assertEqual("BANC", set6.min_window("ADOBECODEBANC", "ABC"))
        self.assertEqual("BAC", set6.min_window("ABAC", "BC"))

if __name__ == '__main__':
    unittest.main()
