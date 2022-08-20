class pair{
	node first;
	int state;

	pair(node first,int state)
	{
		this.first = first;
		this.state = state;
	}
	
	@Override
	public String toString()
	{
		return "<"+first.data+", "+state+">";
	}
}