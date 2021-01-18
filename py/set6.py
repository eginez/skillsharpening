from typing import List


def max_subarray(nums: List[int]) -> int:
    n = [[0 for i in range(len(nums))] for j in range(len(nums))]
    max_num = None
    for i in range(len(nums)):
        for j in range(i, len(nums)):
            if i == j:
                n[i][j] = nums[i]
                continue
            if i == 0:
                prev = max(j -1, 0)
                n[i][j] = n[i][prev] + nums[j]
            else:
                n[i][j] = n[i - 1][j] - nums[i -1]
            if max_num is None or n[i][j] >= max_num:
                max_num = n[i][j]
    return max_num




def min_awk(arr):
    pass


def sort_k_lists(lists: List[List[int]]) -> List[int]:
    heads: List[int] = []
    res: List[int] = []

    all_elems = 0
    copied_elems = 0
    for l in lists:
        all_elems += len(l)

    while len(res) < all_elems:
        min, min_pos = None, None
        for i in range(len(lists)):
            if len(lists[i]) == 0:
                continue
            l = lists[i]
            head = l[0]
            if min is None or head < min:
                min, min_pos = head, i

        lists[min_pos].pop(0)
        res += [min]
    return res


def search_rotated_sorted(target: int, arr: List[int]) -> bool:
    pos = len(arr) // 2
    if arr[pos] == target:
        return True

    if len(arr) == 1:
        return False

    # Ordered do normal binary search
    if arr[0] <= arr[-1]:
        if target > arr[pos]:
            lim = min(pos + 1, len(arr) - 1)
            return search_rotated_sorted(target, arr[lim:])
        else:
            lim = max(1, pos)
            return search_rotated_sorted(target, arr[:lim])
    else:  # Not ordered array
        if target <= arr[pos]:
            if arr[0] <= target:
                lim = max(1, pos)
                return search_rotated_sorted(target, arr[:lim])
            else:
                lim = min(pos + 1, len(arr) - 1)
                return search_rotated_sorted(target, arr[lim:])
        else:
            if arr[-1] >= target:
                lim = min(pos + 1, len(arr) - 1)
                return search_rotated_sorted(target, arr[lim:])
            else:
                lim = max(1, pos)
                return search_rotated_sorted(target, arr[:lim])


if __name__ == "__main__":
    print("sharpening")
