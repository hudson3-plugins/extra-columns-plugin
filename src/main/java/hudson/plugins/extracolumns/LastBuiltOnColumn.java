/*
 * The MIT License
 *
 * Copyright (c) 2014, Lukasz Jader
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package hudson.plugins.extracolumns;

import hudson.Extension;
import hudson.model.AbstractBuild;
import hudson.model.Job;
import hudson.model.Run;
import hudson.views.ListViewColumnDescriptor;
import hudson.views.ListViewColumn;
import hudson.views.extra.Messages;

import org.kohsuke.stapler.DataBoundConstructor;

/**
 * This column shows node name on which job last build was run
 * 
 * @author Lukasz Jader
 * 
 */
public class LastBuiltOnColumn extends ListViewColumn {
    private boolean showAbsentNodeInfo;

    @DataBoundConstructor
    public LastBuiltOnColumn(boolean showAbsentNodeInfo) {
        super();
        this.showAbsentNodeInfo = showAbsentNodeInfo;
    }

    public boolean isShowAbsentNodeInfo() {
        return showAbsentNodeInfo;
    }

    public AbstractBuild<?, ?> getLastBuild(Job<?, ?> job) {
        Run<?, ?> r = job.getLastBuild();
        if (r == null) {
            return null;
        }

        if (!(r instanceof AbstractBuild<?, ?>)) {
            return null;
        }

        return (AbstractBuild<?, ?>) r;
    }

    @Extension
    public static class DescriptorImpl extends ListViewColumnDescriptor {

        @Override
        public boolean shownByDefault() {
            return false;
        }

        @Override
        public String getDisplayName() {
            return Messages.LastBuiltOnColumn_DisplayName();
        }
    }
}
