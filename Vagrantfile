VAGRANTFILE_API_VERSION = "2"

  Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

  config.vm.box = "hashicorp/precise64"

  config.vm.define :database do |db_config|
    db_config.vm.host_name = "stream-db"
    db_config.vm.network :private_network,
                         :ip => "192.168.33.14"
  end

end