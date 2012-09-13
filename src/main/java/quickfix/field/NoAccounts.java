package quickfix.field;

import quickfix.IntField;

public class NoAccounts extends IntField {
	
	static final long serialVersionUID = 20050617;
    public static final int FIELD = 20058;

    public NoAccounts() {
        super(FIELD);
    }

    public NoAccounts(int data) {
        super(FIELD, data);
    }

}
