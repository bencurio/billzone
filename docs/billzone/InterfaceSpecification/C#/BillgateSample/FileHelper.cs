using System.IO;
using System.Xml.Serialization;

namespace BillgateSample
{
    public static class FileHelper
    {
        public static StringWriter Serialize(object o)
        {
            var xs = new XmlSerializer(o.GetType());

            var xml = new StringWriter();

            xs.Serialize(xml, o);

            return xml;
        }


        public static void SaveStreamToXml(string content, string filename)
        {
            var path = Directory.GetCurrentDirectory();

            using (var outputFile = new StreamWriter(path + "\\" + filename + ".xml"))
            {
                outputFile.WriteLine(content);

                outputFile.Close();
            }
        }
    }
}