package com.example.geektrust;

public enum ActionType {

	BALANCE {
		@Override
		public String[] perform(String[] args) {
			return new String[] { args[1], args[2] };
		}
	},

	CHECK_IN {
		@Override
		public String[] perform(String[] args) {
			return new String[] { args[1], args[2], args[3] };
		}
	},

	PRINT_SUMMARY {
		@Override
		public String[] perform(String[] args) {
			return null;
		}
	};

	public static ActionType forName(String inputType) {
		if (ActionType.BALANCE.toString().equals(inputType)) {
			return ActionType.BALANCE;
		} else if (ActionType.CHECK_IN.toString().equals(inputType)) {
			return ActionType.CHECK_IN;
		} else if (ActionType.PRINT_SUMMARY.toString().equals(inputType)) {
			return ActionType.PRINT_SUMMARY;
		} else {
			return null;
		}
	}

	public abstract String[] perform(String[] args);
}
