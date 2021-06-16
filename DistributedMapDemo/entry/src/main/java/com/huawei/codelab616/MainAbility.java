/*
 * Copyright (c) 2021 Huawei Device Co., Ltd.
 * Licensed under the Apache License,Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huawei.codelab616;

import com.huawei.codelab616.slice.MainAbilitySlice;
import com.huawei.codelab616.util.LogUtils;
import com.huawei.codelab616.util.PermissionsUtils;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.IAbilityContinuation;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.IntentParams;
import ohos.security.SystemPermission;

/**
 * MainAbility
 *
 * @since 2021-03-12
 */
public class MainAbility extends Ability implements IAbilityContinuation {
    private static final String TAG = MainAbility.class.getSimpleName();

    private String[] requestPermissions = {SystemPermission.DISTRIBUTED_DATASYNC, SystemPermission.LOCATION};

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(MainAbilitySlice.class.getName());
        PermissionsUtils.getInstance().requestPermissions(this, requestPermissions);
    }

    @Override
    public void onRequestPermissionsFromUserResult(int requestCode, String[] permissions, int[] grantResults) {
        PermissionsUtils.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public boolean onStartContinuation() {
        LogUtils.info(TAG, "onStartContinuation");
        return true;
    }

    @Override
    public boolean onSaveData(IntentParams intentParams) {
        LogUtils.info(TAG, "onSaveData");
        return true;
    }

    @Override
    public boolean onRestoreData(IntentParams intentParams) {
        LogUtils.info(TAG, "onRestoreData");
        return true;
    }

    @Override
    public void onCompleteContinuation(int position) {
        LogUtils.info(TAG, "onCompleteContinuation");
    }

    @Override
    public void onRemoteTerminated() {
        LogUtils.info(TAG, "onRemoteTerminated");
    }
}
