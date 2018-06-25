package com.cslong.app.lifetools.rooter.simple;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by chenlongjian on 2018/6/25.
 */

public interface RouterSimple {

    RouterSimple flags(int flags);

    RouterSimple with(Bundle bundle);

    boolean start(Context context);

    boolean start(Activity activity, int requestCode);

}
