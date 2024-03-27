// 在项目内打包。npm run build-ym
// 来到开发环境路径下（VIOT-RN61）。运行npm run buildzip 可以压缩对应名字下的项目并修改需要处理的包名.用于上传给云米平台


//nodejs打包
//命令行执行 node package projectname ios , node package projectname android 打包相应平台
var fs = require("fs");
const compressing = require("compressing");
const pump = require("pump");
const path = require("path");
var exec = require("child_process").exec;
function deleteFolderRecursive(path) {
    if (fs.existsSync(path)) {
        fs.readdirSync(path).forEach(function (file) {
            var curPath = path + "/" + file;
            if (fs.statSync(curPath).isDirectory()) {
                deleteFolderRecursive(curPath);
            } else {
                fs.unlinkSync(curPath);
            }
        });
        fs.rmdirSync(path);
    }
}
var system = process.argv[3];
var projectName = process.argv[2];
if (!projectName) {
    console.log("need projectName param");
} else {
    console.log("process.argv", process.argv);

    let projectPath = "./projects/" + projectName + "/build/bundle." + system;
    let zipFile = "./bundlezip/bundle." + system + ".zip";

    //单个
    if (system === "ios" || system === "android") {
        let ziparr = [
            // "com.viot.waterheater.u67",
            // "com.viomi.waterheater.u67",
            // "com.viot.waterheater.u68",
            // "com.viomi.waterheater.u68",
            // "com.viot.waterheater.u69",
            // "com.viomi.waterheater.u69",
            "com.viot.waterheater.u72",
            // "com.viot.ewaterheater.e47",
            // "com.viot.ewaterheater.e48",
        ];

        for (var i = 0; i < ziparr.length; i++) {

         console.log("success 进入压缩状态",i);

            // 1修改package_name
            var obj = JSON.parse(fs.readFileSync("./projects/" + projectName + "/package-" + system + ".json"));
            obj.package_name = ziparr[i] + "." + system;
            var str = JSON.stringify(obj);
            fs.writeFileSync("./projects/" + projectName + "/build/bundle." + system + "/package.json", str);

            // 读文件
            let zipStream = new compressing.zip.Stream();
            fs.readdirSync(projectPath).forEach((item, index) => {
                let zipItem = path.join(projectPath, item);
                zipStream.addEntry(zipItem);
            });

            // zipFile = "./bundlezip/"+i+"bundle." + system + ".zip";
            zipFile = "./bundlezip/bundle." + system + ".zip";
            //压缩文件
            // console.log("zipFile", zipFile);
            console.log("success 进入压缩状态");
            pump(zipStream, fs.createWriteStream(zipFile), (err) => {
                if (err) {
                    console.log("err", err);
                } else {
                    console.log("success", system);
                }
            });
        }
       
    }

    //多个
    
}
