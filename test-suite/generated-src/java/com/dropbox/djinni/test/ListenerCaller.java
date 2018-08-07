// AUTOGENERATED FILE - DO NOT MODIFY!
// This file generated by Djinni from multiple_inheritance.djinni

package com.dropbox.djinni.test;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * Tester for the ability to call two interfaces which might be
 * implemented on the same object.  That's not relevant in all
 * languages, due to the details of multiple inheritance and object
 * comparison.
 */
public interface ListenerCaller {
    public void callFirst();

    public void callSecond();

    @CheckForNull
    public static ListenerCaller init(@CheckForNull FirstListener firstL, @CheckForNull SecondListener secondL)
    {
        return CppProxy.init(firstL,
                             secondL);
    }

    static final class CppProxy implements ListenerCaller
    {
        private final long nativeRef;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);

        private CppProxy(long nativeRef)
        {
            if (nativeRef == 0) throw new RuntimeException("nativeRef is zero");
            this.nativeRef = nativeRef;
        }

        private native void nativeDestroy(long nativeRef);
        public void _djinni_private_destroy()
        {
            boolean destroyed = this.destroyed.getAndSet(true);
            if (!destroyed) nativeDestroy(this.nativeRef);
        }
        protected void finalize() throws java.lang.Throwable
        {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override
        public void callFirst()
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_callFirst(this.nativeRef);
        }
        private native void native_callFirst(long _nativeRef);

        @Override
        public void callSecond()
        {
            assert !this.destroyed.get() : "trying to use a destroyed object";
            native_callSecond(this.nativeRef);
        }
        private native void native_callSecond(long _nativeRef);

        @CheckForNull
        public static native ListenerCaller init(@CheckForNull FirstListener firstL, @CheckForNull SecondListener secondL);
    }
}
