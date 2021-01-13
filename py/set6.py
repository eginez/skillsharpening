from typing import List


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
