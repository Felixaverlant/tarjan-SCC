tarjan-SCC
==========

scala implementation of the Tarjan SCC algorithm based on this one https://github.com/bwesterb/py-tarjan (only the SCC part).

If I have time, i'll try to make more "scala".

# Example #
```scala
tarjan_scc(Map(
  1 -> List(2),    2 -> List(1, 5), 3 -> List(4),
  4 -> List(3, 5), 5 -> List(6),    6 -> List(7),
  7 -> List(8),    8 -> List(6, 9), 9 -> Nil
))
```