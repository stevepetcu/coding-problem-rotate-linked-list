# Daily Coding Problem #699 [Easy]

Problem asked by Airbnb.

## Problem Statement

Given a linked list and a positive integer `k`, rotate the list to the right by `k` places.

For example, given the linked list `7 -> 7 -> 3 -> 5` and `k = 2`, it should become `3 -> 5 -> 7 -> 7`.

Given the linked list `1 -> 2 -> 3 -> 4 -> 5` and `k = 3`, it should become `3 -> 4 -> 5 -> 1 -> 2`.

## Assumptions made for this solution
1. k should always be >= 0
2. if k is < 0 or == 0, we'll return the list unchanged
3. if k > size of the list input, we keep rotating the list
4. if the list is empty, we skip rotating the list

## Potential improvements
The `ListUtils::rotateLikedListBy` function should have a complexity of O(x), where x = places * 2:
For each iteration of the while loop, we are removing an element from the end of the list == O(1)
and placing it at the beginning == O(1) and we are doing (places) number of iterations.

We could look at optimising this using the `LinkedList::subList` method. We'd need to measure the performance of
the method, to make sure we're actually getting an improvement.

Another way to try and improve this would be rolling out our own implementation of a linked list, with a
custom `LinkedListItem` DTO. We could get the element at ~ the `(list.size() - places - 1)` position and change its
"nextElement" pointer to `null`; then we'd need to change the last-element-of-the-list's "nextElement" pointer to =
the first element of the list.
