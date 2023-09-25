public class Action {

	private Activity activity;
	ActionType type;

	/**
	 * 
	 * @param lastActivity
	 */
	public Action(Activity lastActivity,int type) {
		this.activity=lastActivity;
		if(type==1)
			this.type=ActionType.ADD;
		else if(type==2)
			this.type=ActionType.MODIFY;
		else if(type==3)
			this.type=ActionType.DELETE;

	}

	/**
	 *
	 * @return Activity last action done by the user
	 */
	public Activity getActivity() {

		return this.activity;
	}

	/**
	 * 
	 * @param activity
	 */
	public void setActivity(Activity activity) {

		this.activity = activity;
	}


	public ActionType getType(){
		return this.type;
	}

	/**
	 *
	 * @return type (1: ADD) (2: MODIFY) (3: DELETE)
	 */
	public void setType(int type){
		switch(type){
			case 1:
				this.type=ActionType.ADD;
				break;
			case 2:
				this.type=ActionType.MODIFY;
				break;
			case 3:
				this.type=ActionType.DELETE;
				break;
		}
	}

}