package cn.myperf4j.asm;

import cn.myperf4j.core.AbstractRecorderMaintainer;
import cn.myperf4j.core.Recorders;
import cn.myperf4j.core.config.ProfilingParams;

/**
 * Created by LinShunkang on 2018/4/26
 */
public class ASMRecorderMaintainer extends AbstractRecorderMaintainer {

    private static final ASMRecorderMaintainer instance = new ASMRecorderMaintainer();

    public static ASMRecorderMaintainer getInstance() {
        return instance;
    }


    @Override
    public boolean initOther() {
        return true;
    }

    public void addRecorder(int tagId, String tag, ProfilingParams params) {
        for (int i = 0; i < recordersList.size(); ++i) {
            Recorders recorders = recordersList.get(i);
            recorders.setRecorder(tagId, createRecorder(tag, params.getMostTimeThreshold(), params.getOutThresholdCount()));
        }
    }
}
