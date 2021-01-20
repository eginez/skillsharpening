from typing import List


def min_windows_helper(root, children: List[List[int]]) -> ([int], int):
    if len(children) == 0:
        return [root], 0

    min_val = None

    for i in children[0]:
        child_val, diff = min_windows_helper(i, children[1:])
        len_diff = abs(child_val[0] - root)
        max_dis = max(len_diff, diff)
        if min_val is None or max_dis < min_val[1]:
            min_val = ([root] + child_val, max_dis)
    return min_val


def min_window(word: str, target: str) -> str:
    letters = {}
    for i in range(len(word)):
        l = word[i]
        if l in letters:
            letters[l] += [i]
        else:
            letters[l] = [i]

    arr = []
    for t in target:
        arr += [letters[t]]

    min_dis = None
    pos = []
    for i in arr[0]:
        pos, dis = min_windows_helper(i, arr[1:])
        if min_dis is None or min_dis[1] < dis:
            min_dis = pos, dis
    pos.sort()
    return word[pos[0]:pos[-1] + 1]




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
