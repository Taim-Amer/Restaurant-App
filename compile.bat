@echo off

:: تحقق من وجود المجلد bin وإذا كان موجودًا يتم تخطي إنشائه
if not exist "bin" mkdir "bin"

:: إنشاء قائمة بجميع ملفات .java في src مع إحاطة المسارات بين علامات اقتباس
(for /r "src" %%f in (*.java) do echo "%%f") > sources.txt

:: تجميع جميع الملفات باستخدام javac مع إضافة علامات اقتباس حول المسارات
javac -cp "libs\gson-2.11.1-SNAPSHOT.jar" -d "bin" @sources.txt

:: مسح ملف المصادر المؤقت
del sources.txt

echo Compilation complete!
