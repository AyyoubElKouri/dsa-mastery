# DSA Mastery

I don't trust "I understand this" until I can build it from nothing and explain
every line of it. This repo is that standard applied to every core data structure
and algorithm, no library doing the hard part for me, no skipped edge cases,
nothing marked done in [PROGRESS.md](./PROGRESS.md) until it has a from-scratch implementation,
a runnable demo, and problems solved with it.

Slow, deliberate, one topic at a time, the same way I try to approach anything
worth actually mastering, on the way to the depth a principal engineer is
expected to have.

## Structure

```
src/main/java/com/ayyoub/dsa/
├── datastructures/
│   ├── linear/        — array, linkedlist, stack, queue
│   ├── hashbased/      — hashtable, hashset
│   ├── trees/          — binarytree, bst, avl, red-black, splay, heap, etc.
│   ├── graphs/          — representations, disjoint set
│   └── advanced/        — bloom filter, skiplist, lru cache
└── algorithms/
    ├── searching/
    ├── sorting/
    ├── recursion/
    ├── graphalgorithms/
    ├── dynamicprogramming/
    ├── greedy/
    ├── backtracking/
    ├── stringalgorithms/
    ├── mathnumbertheory/
    └── advanced/
```

## Running

```bash
# list available demos
mvn compile exec:java

# run a specific demo
mvn compile exec:java -Dexec.args="array"
```

## Progress

See [PROGRESS.md](./PROGRESS.md) for the full checklist.
