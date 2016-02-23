VAGRANTFILE_API_VERSION = "2"

  Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

  config.vm.box = "hashicorp/precise64"

  config.vm.define :database do |db_config|
    db_config.vm.host_name = "stream-db"
    db_config.vm.network :private_network,
                         :ip => "192.168.33.14"
  end

  config.vm.define :application do |application_config|
    application_config.vm.host_name = "stream-web"
    application_config.vm.provision "file", source: "infrastructure/provision/tomcat-users.xml", destination: "~/tomcat-users.xml"
    application_config.vm.provision "shell", path: "infrastructure/provision/tomcat.sh"
    application_config.vm.network :private_network,
                                  :ip => "192.168.33.15"

  end

end