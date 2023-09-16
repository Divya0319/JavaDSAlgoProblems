package main.java.NarasimhaKarumanchi.java._9_c_Graphs;

public class Pair<F, S> {

	public final F first;
	public final S second;

	public Pair(F first, S second) {
		assert first != null;
		assert second != null;

		this.first = first;
		this.second = second;
	}


	@Override
	public int hashCode() {
		return first.hashCode() ^ second.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair))
			return false;
		Pair pairo = (Pair) o;
		return this.first.equals(pairo.first) && this.second.equals(pairo.second);
	}

}
