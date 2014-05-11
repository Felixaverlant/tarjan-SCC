
import  scala.collection.mutable.{Buffer,Set,Map}

def tarjan_scc(g: Map[Int, List[Int]])= {
  val st = Buffer.empty[Int]
  val st_set = Set.empty[Int]
  val i = Map.empty[Int, Int]
  val lowl = Map.empty[Int, Int]
  val rt = Buffer.empty[Buffer[Int]]

  def visit(v: Int): Unit = {
    i(v) = i.size
    lowl(v) = i(v)
    st += v
    st_set += v

    for (w <- g(v)) {
      if (!i.contains(w)) {
        visit(w)
        lowl(v) = math.min(lowl(w), lowl(v))
      } else if (st_set(w)) {
        lowl(v) = math.min(lowl(v), i(w))
      }
    }

    if (lowl(v) == i(v)) {
      val scc = Buffer.empty[Int]
      var w = -1

      while(v != w) {
        w = st.remove(st.size - 1)
        scc += w
        st_set -= w
      }

      rt += scc
    }
  }

  for (v <- g.keys) if (!i.contains(v)) visit(v)
  rt
}
