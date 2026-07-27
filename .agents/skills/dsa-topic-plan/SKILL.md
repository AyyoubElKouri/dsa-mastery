---
name: dsa-topic-plan
description: Generates a Theory/Build/Practice study-and-implementation plan for one topic from the user's Java "DSA Mastery" repo (package com.ayyoub.dsa, structured as datastructures/... and algorithms/...). Always use this skill whenever the user says they want to work on, start, tackle, learn, or build a specific data structure or algorithm (e.g. "let's do arrays", "help me with AVL tree", "what should I build for quicksort", "next topic", "I'm starting on segment tree today"), even if they don't ask for a "plan" by name — a bare topic name in this context is a request for this output. Do not give an ad-hoc explanation instead of using this skill when the topic is one of the ~60 items in references/checklist.md.
---

# DSA Topic Plan

Produces one topic's worth of theory + implementation + practice guidance, scaled to
that topic's time budget, in the fixed format the user has already settled on (the
Array plan below is the canonical example — match its depth and tone, not just its
headers).

## Workflow

1. **Identify the topic.** Match the user's phrasing against `references/checklist.md`.
   - If it's ambiguous between variants (e.g. "queue" → simple/circular/deque/priority,
     "heap" → min/max), cover the general case as the main build and name the variants
     as a one-line "also worth doing" note rather than stopping to ask — momentum matters
     more than precision here.
   - If the topic isn't in the checklist at all, say so and ask which checklist item they mean.
2. **Look up the hour budget and folder path** from the checklist reference.
3. **Scale depth to the budget:**
   - ≤2h topics (Linear Search, Euclidean GCD, basic sorts): skip the complexity table,
     keep theory to 2-3 bullets, one implementation file, 1-2 practice problems.
   - 3-5h topics (Array, Stack, BST, most algorithms): full format as in the example below.
   - 6h+ topics (AVL, Segment Tree, Dijkstra, FFT): add a "gotchas" subsection under Build
     for the parts people typically get wrong (e.g. rotation cases, off-by-one in range
     queries) — these topics earn the extra depth.
4. **Output in this structure:**

```
## <Topic Name> — <hours from checklist>

### Theory (~<fraction of budget>)
- concept bullets — mechanism, not just definition
- complexity table if more than one operation/variant is meaningful to compare

### Build (~<fraction of budget>)
<folder path>/
├── <ClassName>.java       — from-scratch, no java.util shortcuts for the core logic
└── <ClassName>Demo.java

- method list with a one-line rationale for anything non-obvious
- reminder: register the demo in Main's static block (see entry-point convention)

### Practice (~<fraction of budget>)
- 2-3 problems max, each with a one-line reason it was picked (not just a title dump)

Offer at the end: "Want me to sketch the <ClassName>.java skeleton?"
```

Budget fractions: roughly 30-40% theory, 45-55% build, 15-20% practice — adjust per topic
(a topic like "Recursion basics" is nearly all theory+small build; "Sudoku Solver" is
almost all build+practice).

## Canonical example (match this bar)

**Input:** "So for the first one, Arrays, what should I learn and build?"

**Output:**

## Array — 3-4h

### Theory (30-45 min)
- Static array: fixed size, contiguous memory, why that gives O(1) random access
  (`base_address + index * element_size`)
- Dynamic array: amortized O(1) append via multiplicative growth (1.5x/2x) vs why
  additive growth would make it O(n) per append
- Cache locality: why arrays beat pointer-chasing structures in practice despite
  equal Big-O

| Operation | Static Array | Dynamic Array (amortized) |
|---|---|---|
| Access by index | O(1) | O(1) |
| Search (unsorted) | O(n) | O(n) |
| Insert at end | O(1)/N/A | O(1) amortized |
| Insert at index | O(n) | O(n) |
| Delete at index | O(n) | O(n) |
| Resize | N/A | O(n) when triggered |

### Build (2-2.5h)
```
datastructures/linear/array/
├── DynamicArray.java
└── DynamicArrayDemo.java
```
- `get`/`set` with bounds checking
- `add(value)` — append, triggers resize when full
- `add(index, value)` — insert with shifting
- `remove(index)` — delete with shifting; optionally shrink at a low-usage threshold
  (teaches the shrink-threshold problem — why 25% not 50%, to avoid thrashing)
- `size()` vs `capacity()` kept distinct and both exposed — that's the whole point
- private `resize()` — doubles capacity, copies elements
- implement `Iterable<T>`

### Practice (30-45 min)
- Two Sum — baseline, surfaces the hashmap-vs-array tradeoff early
- Rotate Array (in-place, O(1) space) — shifting/index-arithmetic workout
- Merge Sorted Array (in-place from the back) — classic direction-of-iteration trap

Want me to sketch the DynamicArray.java skeleton?

## Notes

- The user tracks progress in `PROGRESS.md` and runs demos via a `Main` registry
  (`mvn compile exec:java -Dexec.args="<key>"`) — the Build section should produce output
  consistent with that convention (a `TopicDemo.java` with a static `run()`), not a
  standalone `main()` unless the user has said they dropped the registry pattern.
- Don't pad. If a topic only needs 3 bullets of theory, give 3, not 6.
- This is a personal mastery repo aimed at principal-engineer-level interview depth —
  favor precision and "why," not encyclopedic coverage.
