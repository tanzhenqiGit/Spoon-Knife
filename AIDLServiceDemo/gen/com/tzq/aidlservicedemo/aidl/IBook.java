/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/free/workspace/AIDLServiceDemo/src/com/tzq/aidlservicedemo/aidl/IBook.aidl
 */
package com.tzq.aidlservicedemo.aidl;
public interface IBook extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.tzq.aidlservicedemo.aidl.IBook
{
private static final java.lang.String DESCRIPTOR = "com.tzq.aidlservicedemo.aidl.IBook";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.tzq.aidlservicedemo.aidl.IBook interface,
 * generating a proxy if needed.
 */
public static com.tzq.aidlservicedemo.aidl.IBook asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.tzq.aidlservicedemo.aidl.IBook))) {
return ((com.tzq.aidlservicedemo.aidl.IBook)iin);
}
return new com.tzq.aidlservicedemo.aidl.IBook.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_queryBook:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _result = this.queryBook(_arg0);
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.tzq.aidlservicedemo.aidl.IBook
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String queryBook(int bookNo) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(bookNo);
mRemote.transact(Stub.TRANSACTION_queryBook, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_queryBook = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public java.lang.String queryBook(int bookNo) throws android.os.RemoteException;
}
