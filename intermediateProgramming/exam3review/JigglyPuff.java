class JigglyPuff{
	public int HP = 5;
	private static JigglyPuff INSTANCE = new JigglyPuff();
	private JigglyPuff(){}
	public JigglyPuff getInstance(){return INSTANCE;}
}
