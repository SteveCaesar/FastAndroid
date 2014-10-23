/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\workspace\\Android\\fe-android\\src\\com\\fusai\\lib\\download\\IDownloadService.aidl
 */
package com.fusai.lib.download;
public interface IDownloadService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.fusai.lib.download.IDownloadService
{
private static final java.lang.String DESCRIPTOR = "com.fusai.lib.download.IDownloadService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.fusai.lib.download.IDownloadService interface,
 * generating a proxy if needed.
 */
public static com.fusai.lib.download.IDownloadService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.fusai.lib.download.IDownloadService))) {
return ((com.fusai.lib.download.IDownloadService)iin);
}
return new com.fusai.lib.download.IDownloadService.Stub.Proxy(obj);
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
case TRANSACTION_startManage:
{
data.enforceInterface(DESCRIPTOR);
this.startManage();
reply.writeNoException();
return true;
}
case TRANSACTION_addTask:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.addTask(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_pauseTask:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.pauseTask(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_pauseAll:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.pauseAll(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_deleteTask:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.deleteTask(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_continueTask:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.continueTask(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_stopManage:
{
data.enforceInterface(DESCRIPTOR);
this.stopManage();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.fusai.lib.download.IDownloadService
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
@Override public void startManage() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_startManage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void addTask(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_addTask, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void pauseTask(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_pauseTask, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void pauseAll(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_pauseAll, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void deleteTask(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_deleteTask, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void continueTask(java.lang.String url) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(url);
mRemote.transact(Stub.TRANSACTION_continueTask, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void stopManage() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stopManage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_startManage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_addTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_pauseTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_pauseAll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_deleteTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_continueTask = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_stopManage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
}
public void startManage() throws android.os.RemoteException;
public void addTask(java.lang.String url) throws android.os.RemoteException;
public void pauseTask(java.lang.String url) throws android.os.RemoteException;
public void pauseAll(java.lang.String url) throws android.os.RemoteException;
public void deleteTask(java.lang.String url) throws android.os.RemoteException;
public void continueTask(java.lang.String url) throws android.os.RemoteException;
public void stopManage() throws android.os.RemoteException;
}
