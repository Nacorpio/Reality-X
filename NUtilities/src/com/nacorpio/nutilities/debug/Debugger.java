package com.nacorpio.nutilities.debug;

import com.nacorpio.nutilities.crypt.CryptUtils;
import com.nacorpio.nutilities.date.Date;
import com.nacorpio.nutilities.format.n.EnumVariableType;
import com.nacorpio.nutilities.format.n.NFormat;
import com.nacorpio.nutilities.format.nac.NacFormat;
import com.nacorpio.nutilities.string.TextUtils;
import com.nacorpio.nutilities.threading.BaseThread;
import com.nacorpio.nutilities.threading.BaseThread.Task;

public final class Debugger {

	public static void main(String[] par1) {
		Date var1 = new Date();
		var1.addYears(1);
		System.out.println(var1.getMonths());
	}

}
