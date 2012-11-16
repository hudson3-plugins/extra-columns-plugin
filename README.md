extra-columns-plugin
====================

Changes required for Hudson:

* Fix pom.xml to depend on Hudson, pass Sonatype validation.

* Remove references to Items.XSTREAM2 not in Hudson.

* Change package back to hudson.views to be compatible with older versions of plugin.

* Change hudson.views.Messages to hudson.views.extra.Messages to remove conflict
  with hudson.views.Messages in Hudson.
